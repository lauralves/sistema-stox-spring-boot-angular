import {Component, ElementRef, EventEmitter, Input, NgModule, OnInit, Output} from '@angular/core';
import {MenuItem} from "primeng/api";
import {Router} from "@angular/router";
import {navigation} from "../../app-navigation";

@Component({
  selector: 'app-tab-menu',
  templateUrl: './tab-menu-principal.component.html',
  styleUrls: ['./tab-menu-principal.component.scss']
})
export class TabMenuPrincipalComponent implements OnInit{

  items: MenuItem[] | undefined;

  activeItem: MenuItem | undefined;
  @Output() sidebarVisible: boolean = false;

  constructor(private router: Router, private elementRef: ElementRef) {
  }

  emitButton(){
   return this.sidebarVisible;
  }

  ngOnInit() {
    this.router.events.subscribe(value => {
      this.items = navigation
      this.activeItem = this.items[0];
    })
    }




}
