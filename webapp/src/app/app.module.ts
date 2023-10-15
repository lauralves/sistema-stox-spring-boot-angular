import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PanelMenuModule} from "primeng/panelmenu";
import {TabMenuModule, TabMenuTemplates} from "primeng/tabmenu";
import {TabMenuModulePrincipal} from "./menu/tab-side-menu/tab-menu-principal.module";
import { TopHeaderMenuComponent } from './menu/top-header-menu/top-header-menu.component';
import {PanelModule} from "primeng/panel";

@NgModule({
  declarations: [
    AppComponent,
    TopHeaderMenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PanelMenuModule,
    TabMenuModule,
    TabMenuModulePrincipal,
    PanelModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
