import {Component, OnDestroy, OnInit} from '@angular/core';
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
  providers:[MessageService, DialogService]

})
export class ProdutoPageComponent implements OnInit, OnDestroy {

  constructor(private produtoService: ProdutoService, private route: Router, private messageService: MessageService,
              private dialogService: DialogService) {
  }

  products: any[] = [];
  ref: DynamicDialogRef | undefined;

  ngOnInit(): void {
    this.produtoDataSource();
  }

  produtoDataSource() {
    this.produtoService.findAll().pipe().subscribe(data => {
      this.products = data.data
    })
  }

  create() {
    this.ref = this.dialogService.open(ProdutoDialogComponent, {
      header: 'Criar novo produto',
      width: '70%',
      contentStyle: {overflow: 'auto'},
      baseZIndex: 10000,
      maximizable: true
    });

    this.ref.onClose.subscribe((produto: Produto) => {
      if (produto) {
        this.messageService.add({severity: 'info', summary: 'Product Selected', detail: produto.nome});
      }
    });

    this.ref.onMaximize.subscribe((value) => {
      this.messageService.add({severity: 'info', summary: 'Maximized', detail: `maximized: ${value.maximized}`});
    });
  }

  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }

  protected readonly of = of;
}
