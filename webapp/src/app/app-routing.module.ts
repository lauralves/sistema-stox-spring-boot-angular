import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', loadChildren: () => import('./login-page/login-page.module').then(m => m.LoginPageModule)},
  {path: 'produto', loadChildren: () => import('./produto-page/produto-page.module').then(m => m.ProdutoPageModule)},
  {path: 'venda', loadChildren: () => import('./venda-page/venda-page.module').then(m => m.VendaPageModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
