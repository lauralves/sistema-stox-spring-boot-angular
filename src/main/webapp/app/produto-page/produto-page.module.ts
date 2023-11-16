import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoPageRoutingModule } from './produto-page-routing.module';
import {ProdutoPageComponent} from "./produto-page.component";
import {TableModule} from "primeng/table";


@NgModule({
  declarations: [ProdutoPageComponent],
    imports: [
        CommonModule,
        ProdutoPageRoutingModule,
        TableModule
    ]
})
export class ProdutoPageModule { }
