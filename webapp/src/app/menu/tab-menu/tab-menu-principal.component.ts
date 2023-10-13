import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-tab-menu',
  templateUrl: './tab-menu-principal.component.html',
  styleUrls: ['./tab-menu-principal.component.scss']
})
export class TabMenuPrincipalComponent implements OnInit{
  items: MenuItem[] | undefined;

  activeItem: MenuItem | undefined;

  ngOnInit() {
    this.items = [
      { label: 'Produto', icon: 'pi pi-fw pi-home' },
      { label: 'Vender', icon: 'pi pi-fw pi-wallet' },
      { label: 'Configurações', icon: 'pi pi-fw pi-cog' }
    ];

    this.activeItem = this.items[0];
    }
  }
