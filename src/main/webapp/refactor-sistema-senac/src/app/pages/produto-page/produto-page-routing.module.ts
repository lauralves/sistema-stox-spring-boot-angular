import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoPageComponent } from './produto-page.component';
import { ProdutoListComponent } from './produto-list/produto-list.component';
import { ProdutoDetailComponent } from './produto-detail/produto-detail.component';

const routes: Routes = [
  {path: '', 
  component: ProdutoPageComponent,
  children: [
    {path: '', component: ProdutoListComponent},
    {path: 'detail', component: ProdutoDetailComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoPageRoutingModule { }
