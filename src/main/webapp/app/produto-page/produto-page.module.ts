import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoPageRoutingModule } from './produto-page-routing.module';
import {ProdutoPageComponent} from "./produto-page.component";


@NgModule({
  declarations: [ProdutoPageComponent],
  imports: [
    CommonModule,
    ProdutoPageRoutingModule
  ]
})
export class ProdutoPageModule { }
