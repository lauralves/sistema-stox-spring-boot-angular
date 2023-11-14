import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {VendaPageComponent} from "./venda-page.component";

const routes: Routes = [
  {path: '', component: VendaPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VendaPageRoutingModule { }
