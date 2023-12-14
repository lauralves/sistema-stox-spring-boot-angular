import { CUSTOM_ELEMENTS_SCHEMA, Component, OnInit } from '@angular/core';
import { ConfirmEventType, ConfirmationService, MessageService } from "primeng/api";
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogService, DynamicDialogModule, DynamicDialogRef } from "primeng/dynamicdialog";
import { Table, TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { FornecedorListView } from "../../domain/fornecedor-list-view";
import { FornecedorService } from "../../service/fornecedor.service";
import { FornecedorDialogComponent } from "./fornecedor-dialog/fornecedor-dialog.component";

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.scss'],
  standalone: true,
  imports: [TableModule, ButtonModule, ToastModule, ConfirmDialogModule, DynamicDialogModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [DialogService, MessageService, ConfirmationService, MessageService, FornecedorListView]
})
export class FornecedorComponent implements OnInit {

  ref: DynamicDialogRef | undefined;
  fornecedor: any[] = [];
  fornecedorList!: FornecedorListView

  constructor(private dialogService: DialogService, private fornecedorService: FornecedorService,
    private confirmationService: ConfirmationService, private messageService: MessageService,
    private data: FornecedorListView) {
    this.fornecedorService.findAll().subscribe(data => {
      this.fornecedor = data.data
    })
  }
  ngOnInit() {
  }

  create() {
    this.openNovoFornecedorDialog();
  }
  delete(id: number) {
    this.openDeleteFornecedorDialog(id);
  }
  edit(id: number) {
    this.fornecedorService.findFornecedorById(id).subscribe(
      (fornecedor: FornecedorListView) => this.openEditFornecedorDialog(fornecedor)
    );
  }


  private openNovoFornecedorDialog() {
    this.ref = this.dialogService.open(FornecedorDialogComponent, {
      header: 'Cadastrar novo fornecedor',
      width: '30%',
      height: '25%',
      contentStyle: { overflow: 'hidden' },
      baseZIndex: 10000,
      maximizable: true,
    }),
      this.ref.onClose.subscribe((resource) => {
        if(resource){
          this.fornecedor.push(resource);
          this.messageService.add({
            severity: 'info',
            summary: 'Fornecedor cadastrado com sucesso',
          })
        } else {
          this.messageService.add({
            severity: 'warn',
            summary: 'Você cancelou a operação'
          })
        }
      })
  }

  private openDeleteFornecedorDialog(id: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir?',
      header: 'Confirmar exclusão',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.fornecedorService.deleteFornecedor(id)
          .subscribe(() => {
            this.fornecedor = this.fornecedor.filter((value) => value.id !== id);
            this.messageService.add({ severity: 'info', detail: 'Fornecedor excluído com sucesso', life: 3000 });
          })
      },
      reject: (type: any) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({ severity: 'error', detail: 'Você não excluiu' });
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({ severity: 'warn', detail: 'Você cancelou' });
            break;
        }
      }
    });
  }

  private openEditFornecedorDialog(fornecedor: FornecedorListView) {
    this.ref = this.dialogService.open(FornecedorDialogComponent, {
      data: fornecedor,
      header: 'Atualizar fornecedor',
      width: '30%',
      height: '25%',
      contentStyle: { overflow: 'hidden' },
      baseZIndex: 10000,
      maximizable: true,
    }),
      this.ref.onClose.subscribe((fornecedor) => {
        if(fornecedor) {
          this.fornecedor[this.findIndexById(fornecedor.id)] = fornecedor;
          this.messageService.add({
            severity: 'info',
            summary: 'Fornecedor atualizado com sucesso',
          })
        } else {
          this.messageService.add({
            severity: 'warn',
            summary: 'Você cancelou a operação'
          })
        }
      });

  }
  findIndexById(id: number | undefined): number {
    let index = -1;
    for (let i = 0; i < this.fornecedor.length; i++) {
      if (this.fornecedor[i].id === id) {
        index = i;
        break;
      }
    }

    return index;
  }

  clear(table: Table) {
    table.clear();
  }

  reload() {
    window.location.reload();
  }
}
