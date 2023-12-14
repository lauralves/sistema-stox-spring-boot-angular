import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-produto-detail',
  templateUrl: './produto-detail.component.html',
  styleUrls: ['./produto-detail.component.scss']
})
export class ProdutoDetailComponent implements  OnInit{

  constructor() {
  }
ngOnInit() {
    console.log("oi")
}
}
