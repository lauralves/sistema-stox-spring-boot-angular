import {Component, Injector, OnInit} from '@angular/core';
import {Location} from "@angular/common";
import {Produto} from "../../domain/produto";
import {Estoque} from "../../domain/estoque";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {MessageService} from "primeng/api";
import {ProdutoService} from "../../service/produto.service";

@Component({
  selector: 'app-produto-edit',
  templateUrl: './produto-dialog.component.html',
  styleUrls: ['./produto-dialog.component.scss'],
  providers: [MessageService, DialogService, Produto]
})
export class ProdutoDialogComponent implements OnInit{
  private location: Location;
  produto: Produto;
  // estoque: Estoque;
  constructor(private injector: Injector,
              public ref: DynamicDialogRef,
              private dialogService: DialogService,
              private messageService: MessageService,
              private produtoService: ProdutoService,
              private data: Produto) {
    this.produto = data;
    this.location = injector.get(Location);
  }

  ngOnInit() {
  }

  save(){
    this.ref.onClose.subscribe((produto: Produto) => {
        this.produtoService.createProduto(produto).subscribe(
          (p: Produto) => {
            this.messageService.add({
              severity: 'info',
              summary: 'Produto criado com sucesso',
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
    this.location.back()
  }

}
