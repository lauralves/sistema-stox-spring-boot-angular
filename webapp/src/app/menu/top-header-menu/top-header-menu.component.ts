import {Component, ElementRef} from '@angular/core';

@Component({
  selector: 'app-top-header-menu',
  templateUrl: './top-header-menu.component.html',
  styleUrls: ['./top-header-menu.component.scss']
})
export class TopHeaderMenuComponent {

  constructor(private elementRef: ElementRef) {
  }
  // onMenuToggle(){
  //   if (this.elementRef.nativeElement) {
  //     this.state.overlayMenuActive = !this.state.overlayMenuActive;
  //     if (this.state.overlayMenuActive) {
  //       this.overlayOpen.next(null);
  //     }
  //   }
  //
  //   if (this.isDesktop()) {
  //     this.state.staticMenuDesktopInactive = !this.state.staticMenuDesktopInactive;
  //   }
  //   else {
  //     this.state.staticMenuMobileActive = !this.state.staticMenuMobileActive;
  //
  //     if (this.state.staticMenuMobileActive) {
  //       this.overlayOpen.next(null);
  //     }
  //   }
  // }



}
