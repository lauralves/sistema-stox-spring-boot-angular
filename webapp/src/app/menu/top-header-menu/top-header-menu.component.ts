import {AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-top-header-menu',
  templateUrl: './top-header-menu.component.html',
  styleUrls: ['./top-header-menu.component.scss']
})
export class TopHeaderMenuComponent  implements AfterViewInit{

  @Input()
  menuToggleEnabled = false;


  // @ViewChild('menuButton') menuButton: any;
  constructor(private elementRef: ElementRef) {

  }

  ngAfterViewInit() {
   // console.log(this.onMenuToggle())
  }

  // onMenuToggle(){
  //   if (this.elementRef.nativeElement.menuButton) {
  //     return this.elementRef.nativeElement.querySelector(".menu-principal").style.display == 'none';
  //   }
  //   return this.elementRef.nativeElement.querySelector(".menu-principal").style.display == 'flex';
  // }



}
