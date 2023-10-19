import {Component, ElementRef, EventEmitter, NgModule, OnInit, Output} from '@angular/core';
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

  selectedRoute = '';

  @Output()
  selectedItemChanged = new EventEmitter<string>();
  @Output()
  openMenu = new EventEmitter<any>();

  constructor(private router: Router, private elementRef: ElementRef) {
  }

  ngOnInit() {
    this.router.events.subscribe(value => {
      this.items = navigation
      this.activeItem = this.items[0];
    })
    }

  navigationChanged(event: any) {
    const path = event.routerLink;
    const pointerEvent = event.event;
    if (path && this.activeItem) {
      this.router.navigate([path]);

    } else {
      pointerEvent.preventDefault();
    }
  }



}
