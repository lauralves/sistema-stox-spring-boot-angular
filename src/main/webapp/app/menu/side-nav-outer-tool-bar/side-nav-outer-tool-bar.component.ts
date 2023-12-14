import { CUSTOM_ELEMENTS_SCHEMA, Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { TabMenuPrincipalComponent } from '../tab-side-menu/tab-menu-principal.component';
import { TopHeaderMenuComponent } from '../top-header-menu/top-header-menu.component';
import { ProdutoPageComponent } from '../../pages/produto-page/produto-list/produto-page.component';

@Component({
  selector: 'app-side-nav-outer-tool-bar',
  templateUrl: './side-nav-outer-tool-bar.component.html',
  styleUrls: ['./side-nav-outer-tool-bar.component.scss'],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [RouterModule, TabMenuPrincipalComponent, TopHeaderMenuComponent],
  standalone: true
})
export class SideNavOuterToolBarComponent {

}
