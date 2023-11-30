import {Component} from '@angular/core';
import {ProdutoDialogComponent} from "../produto-page/produto-dialog/produto-dialog.component";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {MessageService} from "primeng/api";
import {FornecedorListView} from "../domain/fornecedor-list-view";
import {FornecedorDialogComponent} from "./fornecedor-dialog/fornecedor-dialog.component";

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.scss'],
  providers: [DialogService, MessageService]
})
export class FornecedorComponent {

  ref: DynamicDialogRef | undefined;
  fornecedor: any[] = [];

  constructor(private dialogService: DialogService,) {

  }

  create() {
    this.openNovoProdutoDialog();
  }

  openNovoProdutoDialog() {
    this.ref = this.dialogService.open(FornecedorDialogComponent, {
      header: 'Adicionar novo fornecedor',
      width: '50%',
      height: '50%',
      contentStyle: {overflow: 'auto'},
      baseZIndex: 10000,
      maximizable: true,
    });

  }
}
