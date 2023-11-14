import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProdutoPageComponent} from "./produto-page.component";

const routes: Routes = [
  {path: '', component: ProdutoPageComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoPageRoutingModule { }
