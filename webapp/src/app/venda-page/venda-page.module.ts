import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VendaPageRoutingModule } from './venda-page-routing.module';
import {VendaPageComponent} from "./venda-page.component";


@NgModule({
  declarations: [VendaPageComponent],
  imports: [
    CommonModule,
    VendaPageRoutingModule
  ]
})
export class VendaPageModule { }
