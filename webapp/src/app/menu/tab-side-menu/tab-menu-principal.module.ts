import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TabMenuPrincipalRoutingModule} from './tab-menu-principal-routing.module';
import {TabMenuPrincipalComponent} from "./tab-menu-principal.component";
import {TabMenuModule} from "primeng/tabmenu";
import {SidebarModule} from 'primeng/sidebar';
import {ButtonModule} from "primeng/button";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  declarations: [TabMenuPrincipalComponent],
  exports: [
    TabMenuPrincipalComponent
  ],
  imports: [
    CommonModule,
    TabMenuPrincipalRoutingModule,
    TabMenuModule,
    SidebarModule,
    ButtonModule,
    BrowserAnimationsModule
  ]
})
export class TabMenuModulePrincipal {
}
