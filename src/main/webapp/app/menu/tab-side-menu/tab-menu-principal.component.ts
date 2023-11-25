import {AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
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
//todo refatorar menu visible
export class TabMenuPrincipalComponent implements OnInit, AfterViewInit {
  @ViewChild('visible', { static: true }) elementRef!: ElementRef;

  items: MenuItem[] | undefined;
  sidebarVisible?: boolean;

  constructor(private router: Router) {
  }

  menuChange(){
    if(this.sidebarVisible) {
      this.showMenu();
    } else {
      this.hideMenu();
    }
  }
  hideMenu(){
    // console.log(this.sidebarVisible)
    this.elementRef.nativeElement.style.display='none';
    this.sidebarVisible = true;
  }
  showMenu(){
    this.elementRef.nativeElement.style.display='block';
    this.sidebarVisible = false;
  }

  ngOnInit() {
    this.createMenu();
  }
  ngAfterViewInit() {
    this.menuChange()
  }

  redirectToPage(item: MenuItem) {
    if(item.routerLink){
      this.router.navigate([item.routerLink]).then(() => {});
    }
  }
  private createMenu() {
    this.items = navigation
  }

}
