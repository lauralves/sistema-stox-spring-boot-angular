import {Component, OnInit} from '@angular/core';
import {ProdutoDialogComponent} from "../produto-page/produto-dialog/produto-dialog.component";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {MessageService} from "primeng/api";
import {FornecedorListView} from "../domain/fornecedor-list-view";
import {FornecedorDialogComponent} from "./fornecedor-dialog/fornecedor-dialog.component";
import {FornecedorService} from "../service/fornecedor.service";

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.scss'],
  providers: [DialogService, MessageService]
})
export class FornecedorComponent implements OnInit{

  ref: DynamicDialogRef | undefined;
  fornecedor: any[] = [];

  constructor(private dialogService: DialogService, private fornecedorService: FornecedorService) {
    this.fornecedorService.findAll().subscribe(data =>{
      this.fornecedor = data.data
    })
  }
  create() {
    this.openNovoProdutoDialog();
  }
  ngOnInit() {
  }

  openNovoProdutoDialog() {
    this.ref = this.dialogService.open(FornecedorDialogComponent, {
      header: 'Cadastrar novo fornecedor',
      width: '30%',
      height: '30%',
      contentStyle: {overflow: 'hidden'},
      baseZIndex: 10000,
      maximizable: true,
    })
    ;
  }

}
