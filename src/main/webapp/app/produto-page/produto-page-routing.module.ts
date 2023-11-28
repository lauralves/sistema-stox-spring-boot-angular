import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProdutoPageComponent} from "./produto-list/produto-page.component";
import {ProdutoDetailComponent} from "./produto-detail/produto-detail.component";
import {ProdutoDialogComponent} from "./produto-dialog/produto-dialog.component";

const routes: Routes = [
  {
    path: '',
    component: ProdutoPageComponent,
  },
  {
    path: 'new',
    component: ProdutoDialogComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoPageRoutingModule {
}
