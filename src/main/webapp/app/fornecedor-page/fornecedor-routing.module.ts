import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FornecedorComponent} from "./fornecedor.component";

const routes: Routes = [
  {path: '', component: FornecedorComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FornecedorRoutingModule { }
