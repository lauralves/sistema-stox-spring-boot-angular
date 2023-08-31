import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutoPageRoutingModule } from './produto-page-routing.module';
import { ProdutoPageComponent } from './produto-page.component';
import { ProdutoListComponent } from './produto-list/produto-list.component';
import { ProdutoDetailComponent } from './produto-detail/produto-detail.component';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { SideNavOuterToolbarComponent } from 'src/app/side-nav-outer-toolbar/side-nav-outer-toolbar.component';


@NgModule({
  declarations: [ProdutoPageComponent, ProdutoListComponent, ProdutoDetailComponent, SideNavOuterToolbarComponent],
  imports: [
    CommonModule,
    ProdutoPageRoutingModule,
    SidebarModule,
    ButtonModule
  ]
})
export class ProdutoPageModule { }
