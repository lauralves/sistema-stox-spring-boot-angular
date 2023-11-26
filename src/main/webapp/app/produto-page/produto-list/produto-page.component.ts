import {Component, OnInit} from '@angular/core';
import {ProdutoService} from "../../service/produto.service";
import {Produto} from "../../domain/produto";
import {of} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-produto-page',
  templateUrl: './produto-page.component.html',
  styleUrls: ['./produto-page.component.scss']
})
export class ProdutoPageComponent implements OnInit{

  constructor(private produtoService: ProdutoService, private route: Router) {
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

  produtoNew(){
    this.route.navigateByUrl("/new")
  }
  protected readonly of = of;
}
