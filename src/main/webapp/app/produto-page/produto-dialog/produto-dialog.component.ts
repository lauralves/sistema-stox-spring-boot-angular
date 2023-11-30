import {Component, Injector, OnInit} from '@angular/core';
import {Location} from "@angular/common";
import {ProdutoListView} from "../../domain/produto-list-view";
import {EstoqueListView} from "../../domain/estoque-list-view";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {MessageService} from "primeng/api";
import {ProdutoService} from "../../service/produto.service";

@Component({
  selector: 'app-produto-edit',
  templateUrl: './produto-dialog.component.html',
  styleUrls: ['./produto-dialog.component.scss'],
  providers: [MessageService, DialogService, ProdutoListView]
})
export class ProdutoDialogComponent implements OnInit{
  private location: Location;
  produto: ProdutoListView;
  // estoque: EstoqueListView;
  constructor(private injector: Injector,
              public ref: DynamicDialogRef,
              private dialogService: DialogService,
              private messageService: MessageService,
              private produtoService: ProdutoService,
              private data: ProdutoListView) {
    this.produto = data;
    this.location = injector.get(Location);
  }

  ngOnInit() {
  }

  save(){
    this.ref.onClose.subscribe((produto: ProdutoListView) => {
        this.produtoService.createProduto(produto).subscribe(
          (p: ProdutoListView) => {
            this.messageService.add({
              severity: 'info',
              summary: 'ProdutoListView criado com sucesso',
              detail: p.nome,
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
