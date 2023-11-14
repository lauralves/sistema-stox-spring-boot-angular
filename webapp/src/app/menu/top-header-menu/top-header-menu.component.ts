import {AfterViewInit, Component, ElementRef, Input, OnInit, Output, ViewChild} from '@angular/core';
import {TabMenuPrincipalComponent} from "../tab-side-menu/tab-menu-principal.component";

@Component({
  selector: 'app-top-header-menu',
  templateUrl: './top-header-menu.component.html',
  styleUrls: ['./top-header-menu.component.scss']
})
export class TopHeaderMenuComponent  implements AfterViewInit{

  @ViewChild(TabMenuPrincipalComponent) tabMenuPrincipal!: TabMenuPrincipalComponent;
  constructor() {
  }

  sideBarMenuEvent(): any {
    if(!this.tabMenuPrincipal.sidebarVisible){
      return this.tabMenuPrincipal.sidebarVisible = true;
    }
  }
  ngAfterViewInit() {
  }




}
