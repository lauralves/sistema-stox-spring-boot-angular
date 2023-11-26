import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoPageRoutingModule } from './produto-page-routing.module';
import {ProdutoPageComponent} from "./produto-list/produto-page.component";
import {TableModule} from "primeng/table";
import {ButtonModule} from "primeng/button";
import {ProdutoDetailComponent} from "./produto-detail/produto-detail.component";


@NgModule({
  declarations: [ProdutoPageComponent, ProdutoDetailComponent],
    imports: [
        CommonModule,
        ProdutoPageRoutingModule,
        TableModule,
        ButtonModule
    ]
})
export class ProdutoPageModule { }
