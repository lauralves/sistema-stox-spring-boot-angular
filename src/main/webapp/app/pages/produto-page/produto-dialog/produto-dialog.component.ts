import { Location } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, Component, Injector, OnInit } from '@angular/core';
import { MessageService } from "primeng/api";
import { DialogService, DynamicDialogRef } from "primeng/dynamicdialog";
import { FornecedorListView } from '../../../domain/fornecedor-list-view';
import { ProdutoListView } from "../../../domain/produto-list-view";
import { SharedModule } from '../../../provides/shared.module';
import { ProdutoService } from "../../../service/produto.service";

@Component({
  selector: 'app-produto-edit',
  templateUrl: './produto-dialog.component.html',
  styleUrls: ['./produto-dialog.component.scss'],
  providers: [MessageService, DialogService, ProdutoListView],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  standalone: true,
  imports: [SharedModule]
})
export class ProdutoDialogComponent implements OnInit{
  private location: Location;
  produto: ProdutoListView;
  fornecedor?: FornecedorListView [];

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
