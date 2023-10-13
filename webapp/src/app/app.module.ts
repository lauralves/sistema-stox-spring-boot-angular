import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdutoPageComponent } from './produto-page/produto-page.component';
import {PanelMenuModule} from "primeng/panelmenu";
import {TabMenuModule} from "primeng/tabmenu";


@NgModule({
  declarations: [
    AppComponent,
    ProdutoPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PanelMenuModule,
    TabMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
