import { Component, Injector, OnInit } from '@angular/core';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from "primeng/dynamicdialog";
import { ConfirmEventType, ConfirmationService, MessageService } from "primeng/api";
import { FornecedorListView } from "../domain/fornecedor-list-view";
import { FornecedorDialogComponent } from "./fornecedor-dialog/fornecedor-dialog.component";
import { FornecedorService } from "../service/fornecedor.service";
import { ProdutoListView } from '../domain/produto-list-view';

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.scss'],
  providers: [DialogService, MessageService, ConfirmationService, MessageService, FornecedorListView]
})
export class FornecedorComponent implements OnInit {

  ref: DynamicDialogRef | undefined;
  fornecedor: any[] = [];

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
      height: '30%',
      contentStyle: { overflow: 'hidden' },
      baseZIndex: 10000,
      maximizable: true,
    }),
    this.ref.onClose.subscribe( () =>{
        this.messageService.add({
          severity: 'info',
          summary: 'Fornecedor cadastrado com sucesso',
        })
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
            this.messageService.add({ severity: 'info', detail: 'Fornecedor excluído com sucesso' });
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
      height: '30%',
      contentStyle: { overflow: 'hidden' },
      baseZIndex: 10000,
      maximizable: true,
    });

  }

  reload() {
    window.location.reload();
  }
}
