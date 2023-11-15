import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {MenuItem} from "primeng/api";
import {Router} from "@angular/router";
import {navigation} from "../../app-navigation";
import {Sidebar} from "primeng/sidebar";
import {relative} from "@angular/compiler-cli";

@Component({
  selector: 'app-tab-menu',
  templateUrl: './tab-menu-principal.component.html',
  styleUrls: ['./tab-menu-principal.component.scss']
})
export class TabMenuPrincipalComponent implements OnInit {
  // @ViewChild(Sidebar) sideBar: Sidebar

  items: MenuItem[] | undefined;
  sidebarVisible: boolean = false;

  constructor(private router: Router, elementRef: ElementRef) {
  }


  ngOnInit() {
    this.createMenu();
  }

  redirectToPage(item: MenuItem) {
    if(item.routerLink){
      this.router.navigate([item.routerLink]).then(() => {});
      this.sidebarVisible = false;
    }
  }

  private createMenu() {
    this.items = navigation
  }

}
