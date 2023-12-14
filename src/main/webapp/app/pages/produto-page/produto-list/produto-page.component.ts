import { CUSTOM_ELEMENTS_SCHEMA, Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { MessageService } from "primeng/api";
import { DialogService, DynamicDialogRef } from "primeng/dynamicdialog";
import { of } from "rxjs";
import { ProdutoService } from "../../../service/produto.service";
import { ProdutoDialogComponent } from "../produto-dialog/produto-dialog.component";
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss'],
  providers: [MessageService, DialogService],
  imports: [TableModule, ButtonModule, ToastModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  standalone: true,
})
export class ProdutoPageComponent implements OnInit, OnDestroy {

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
      header: 'Cadastrar novo produto',
      width: '35%',
      height: '40%',
      contentStyle: {overflow: 'hidden'},
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
