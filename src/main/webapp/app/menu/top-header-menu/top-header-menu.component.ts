import {AfterViewInit, Component, ElementRef, Input, OnInit, Output, ViewChild} from '@angular/core';
import {TabMenuPrincipalComponent} from "../tab-side-menu/tab-menu-principal.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-top-header-menu',
  templateUrl: './top-header-menu.component.html',
  styleUrls: ['./top-header-menu.component.scss'],
  standalone: true,
  imports: [RouterModule, TabMenuPrincipalComponent],
})
export class TopHeaderMenuComponent  implements AfterViewInit{

  @ViewChild(TabMenuPrincipalComponent) tabMenuPrincipal!: TabMenuPrincipalComponent;
  constructor() {
  }

  sideBarMenuEvent(): any {
      this.tabMenuPrincipal.menuChange()
  }
  ngAfterViewInit() {
  }




}
