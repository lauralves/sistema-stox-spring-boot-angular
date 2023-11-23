import {Component, OnInit} from '@angular/core';
import {ProdutoService} from "../service/produto.service";
import {Produto} from "../domain/produto";
import {of} from "rxjs";

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss']
})
export class ProdutoPageComponent implements OnInit{

  constructor(private produtoService: ProdutoService) {
  }

  products: any[] = [];

  ngOnInit(): void {
    this.produtoDataSource();
  }

  produtoDataSource(){
    this.produtoService.findAll().pipe().subscribe(data => {
      this.products = data.data
    })
  }

  protected readonly of = of;
}
