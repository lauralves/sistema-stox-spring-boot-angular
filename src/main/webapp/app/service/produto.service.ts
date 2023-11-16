import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Produto} from "../domain/produto";

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  URL_API: string = `http://localhost:8081/itemflow/api/`;

  constructor(private httpClient: HttpClient) {
  }

  public findAll(): Observable<Produto[]>{
    return this.httpClient.get<Produto[]>(`${this.URL_API}/produto`);
  }
}
