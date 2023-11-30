import { Component } from '@angular/core';
import {ProdutoListView} from "../../domain/produto-list-view";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {FornecedorService} from "../../service/fornecedor.service";
import {MessageService} from "primeng/api";
import {FornecedorListView} from "../../domain/fornecedor-list-view";

@Component({
  selector: 'app-fornecedor-dialog',
  templateUrl: './fornecedor-dialog.component.html',
  styleUrls: ['./fornecedor-dialog.component.scss'],
  providers: [MessageService, DialogService, FornecedorListView]
})
export class FornecedorDialogComponent {

  fornecedor: FornecedorListView;

  constructor(public ref: DynamicDialogRef, private fornecedorService: FornecedorService, private messageService: MessageService,
              private dialogService: DialogService,
              private data: FornecedorListView) {
    this.fornecedor = data;
  }

  save(){
    this.ref.onClose.subscribe((fornecedor: FornecedorListView) => {
      this.fornecedorService.createFornecedor(fornecedor).subscribe(
        (f: FornecedorListView) => {
          this.messageService.add({
            severity: 'info',
            summary: 'Fornecedor adicionado com sucesso',
            detail: f.nome,
          });
        }
      )
    });
    this.ref.onMaximize.subscribe((value) => {
      this.messageService.add({severity: 'info', summary: 'Maximized', detail: `maximized: ${value.maximized}`});
    });

  }
  back(){
    this.ref.close()
  }
}
