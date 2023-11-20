import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Produto} from "../domain/produto";
import {enviroment} from "../enviroments/enviroment";

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  URL_API: string = `${enviroment.contextPath}/api`;

  constructor(protected httpClient: HttpClient) {
  }

  public findAll(): Observable<Produto[]>{
    return this.httpClient.get<Produto[]>(`${this.URL_API}/produto`)
  }
}
