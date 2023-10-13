import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TabMenuPrincipalRoutingModule } from './tab-menu-principal-routing.module';
import {TabMenuPrincipalComponent} from "./tab-menu-principal.component";
import {TabMenuModule} from "primeng/tabmenu";


@NgModule({
  declarations: [TabMenuPrincipalComponent],
  imports: [
    CommonModule,
    TabMenuPrincipalRoutingModule,
    TabMenuModule,
  ]
})
export class TabMenuModulePrincipal { }
