import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', loadChildren: () => import('./login-page/login-page.module').then(m => m.LoginPageModule)},
  {path: 'menu', loadChildren:() => import('./menu/tab-menu/tab-menu-principal.module').then(m => m.TabMenuModulePrincipal)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
