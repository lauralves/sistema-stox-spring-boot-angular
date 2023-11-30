import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {ProdutoService} from "../../service/produto.service";
import {of} from "rxjs";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {Produto} from "../../domain/produto";
import {ProdutoDialogComponent} from "../produto-dialog/produto-dialog.component";

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss'],
  providers: [MessageService, DialogService]

})
export class ProdutoPageComponent implements OnInit, OnDestroy {

  // @ViewChild(ProdutoDialogComponent, {static: true})
  // dialogProduto: ProdutoDialogComponent;
  //
  constructor(private produtoService: ProdutoService, private route: Router, private messageService: MessageService,
              private dialogService: DialogService) {
    this.produtoDataSource();
  }

  products: any[] = [];
  ref: DynamicDialogRef | undefined;

  ngOnInit(): void {
  }

  produtoDataSource() {
    this.produtoService.findAll().pipe().subscribe(data => {
      this.products = data.data
    })
  }

  create() {
    this.openNovoProdutoDialog();
  }

  openNovoProdutoDialog(){
    this.ref = this.dialogService.open(ProdutoDialogComponent, {
      header: 'Criar novo produto',
      width: '50%',
      height: '50%',
      contentStyle: {overflow: 'auto'},
      baseZIndex: 10000,
      maximizable: true,
    });

  }
  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }

  protected readonly of = of;
}
