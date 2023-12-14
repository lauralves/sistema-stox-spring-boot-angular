import { SideNavOuterToolBarComponent } from "./menu/side-nav-outer-tool-bar/side-nav-outer-tool-bar.component";


export const APP_ROUTES = [
  {
    path: '', component: SideNavOuterToolBarComponent,
    children: [
      {
        path: 'produto',
        loadComponent: () => import('./pages/produto-page/produto-list/produto-page.component').then(m => m.ProdutoPageComponent)
      },
      { path: 'fornecedor', 
      loadComponent: () => import('./pages/fornecedor-page/fornecedor.component').then(m => m.FornecedorComponent) }
    ]
  }
];