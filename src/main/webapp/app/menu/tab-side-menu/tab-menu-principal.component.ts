import {AfterViewInit, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {MenuItem} from "primeng/api";
import {Router, RouterModule} from "@angular/router";
import {navigation} from "../../app-navigation";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tab-menu',
  templateUrl: './tab-menu-principal.component.html',
  styleUrls: ['./tab-menu-principal.component.scss'],
  standalone: true,
  imports: [RouterModule, CommonModule],
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
    this.elementRef.nativeElement.style.display='none';
    this.sidebarVisible = true;
  }
  showMenu(){
    this.elementRef.nativeElement.style.display='block';
    this.sidebarVisible = false;
  }

  ngOnInit() {
    this.sidebarVisible=true;
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
