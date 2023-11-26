import {Component, OnInit} from '@angular/core';
import {ProdutoService} from "../../service/produto.service";
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

  create(){
    this.route.navigateByUrl("/produto/new").then(() => {})
  }
  protected readonly of = of;
}
