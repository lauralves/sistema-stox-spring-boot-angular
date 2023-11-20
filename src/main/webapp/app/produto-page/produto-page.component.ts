import {Component, OnInit} from '@angular/core';
import {ProdutoService} from "../service/produto.service";
import {Produto} from "../domain/produto";

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss']
})
export class ProdutoPageComponent implements OnInit{

  constructor(private produtoService: ProdutoService) {
  }

  products!: Produto[];

  ngOnInit(): void {
    this.produtoDataSource();
    // produtoDataSource = new DataS
  }

  produtoDataSource(){
    this.produtoService.findAll().subscribe(
      (response) => {
        this.products = response;
        console.log(this.products)
      }
    )
  }

}
