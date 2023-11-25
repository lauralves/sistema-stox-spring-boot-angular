import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SideNavOuterToolBarComponent} from "./menu/side-nav-outer-tool-bar/side-nav-outer-tool-bar.component";

@NgModule({
  imports: [RouterModule.forRoot([
    {
      path: '', component: SideNavOuterToolBarComponent,
      children: [
        {
          path: 'produto',
          loadChildren: () => import('./produto-page/produto-page.module').then(m => m.ProdutoPageModule)
        },
        {path: 'venda', loadChildren: () => import('./venda-page/venda-page.module').then(m => m.VendaPageModule)},
      ]
    }
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
