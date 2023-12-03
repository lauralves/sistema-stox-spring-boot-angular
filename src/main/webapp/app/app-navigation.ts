/**
 * Array de items do menu para navegar pelo sistema
 */
import {style} from "@angular/animations";

export const navigation = [
  {
    label: 'Produto',
    routerLink: '/produto',
    icon: 'pi pi-box'
  },
  // {
  //   label: 'Vendas',
  //   routerLink: '/venda',
  //   icon: 'pi pi-fw pi-wallet'
  // },
  {
    label: 'Fornecedor',
    routerLink: '/fornecedor',
    icon: 'pi pi-user',
  }
]
