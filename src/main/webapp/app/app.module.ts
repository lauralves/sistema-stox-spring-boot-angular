import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PanelMenuModule} from "primeng/panelmenu";
import {TabMenuModule, TabMenuTemplates} from "primeng/tabmenu";
import {TabMenuModulePrincipal} from "./menu/tab-side-menu/tab-menu-principal.module";
import { TopHeaderMenuComponent } from './menu/top-header-menu/top-header-menu.component';
import {PanelModule} from "primeng/panel";
import { TableModule } from 'primeng/table';
import {SideNavOuterToolBarComponent} from "./menu/side-nav-outer-tool-bar/side-nav-outer-tool-bar.component";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    TopHeaderMenuComponent,
    SideNavOuterToolBarComponent,
    SideNavOuterToolBarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PanelMenuModule,
    TabMenuModule,
    TabMenuModulePrincipal,
    PanelModule,
    TableModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
