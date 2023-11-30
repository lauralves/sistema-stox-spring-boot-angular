import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProdutoPageRoutingModule} from './produto-page-routing.module';
import {ProdutoPageComponent} from "./produto-list/produto-page.component";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {ProdutoDetailComponent} from "./produto-detail/produto-detail.component";
import {ToastModule} from "primeng/toast";
import {DynamicDialogModule} from "primeng/dynamicdialog";
import {ProdutoDialogComponent} from "./produto-dialog/produto-dialog.component";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [ProdutoPageComponent, ProdutoDetailComponent, ProdutoDialogComponent],
  imports: [
    CommonModule,
    ProdutoPageRoutingModule,
    TableModule,
    ButtonModule,
    ToastModule,
    DynamicDialogModule,
    FormsModule,

  ]
})
export class ProdutoPageModule { }
