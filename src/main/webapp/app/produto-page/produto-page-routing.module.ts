import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProdutoPageComponent} from "./produto-list/produto-page.component";
import {ProdutoDetailComponent} from "./produto-detail/produto-detail.component";

const routes: Routes = [
  {
    path: '',
    component: ProdutoPageComponent,
    children: [
      {path: '', component: ProdutoPageComponent},
      {
        path: 'new',
        children: [
          {
            path: '',
            component: ProdutoDetailComponent
          }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoPageRoutingModule {
}
