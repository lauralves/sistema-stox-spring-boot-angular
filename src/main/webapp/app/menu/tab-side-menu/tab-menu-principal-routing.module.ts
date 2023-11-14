import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TabMenuPrincipalComponent} from "./tab-menu-principal.component";

const routes: Routes = [
  {path: '', component: TabMenuPrincipalComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TabMenuPrincipalRoutingModule { }
