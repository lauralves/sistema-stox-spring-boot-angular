import { Component } from '@angular/core';

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss']
})
export class ProdutoPageComponent {

  teste(){
    console.log("chegou em produto")
  }
}
