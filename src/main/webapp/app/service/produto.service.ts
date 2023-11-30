import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";
import {Produto} from "../domain/produto";
import {enviroment} from "../enviroments/enviroment";
import {Page} from "../@core/types/page";

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  URL_API: string = `${enviroment.contextPath}/api`;

  constructor(protected httpClient: HttpClient) {
  }

  public findAll<T>(): Observable<{data: T[]; totalCount: number}> {
    return this.httpClient.get<Page<T>>(`${this.URL_API}/produto`)
      .pipe(
        map((page: Page<T>) => ({
          data: page.content,
          totalCount: page.totalElements!== undefined ? page.totalElements : 0
        })),
        catchError(error => {
          return throwError(new Error(error.message))
        })
      )
  }
  public createProduto(produto: Produto): Observable<Produto>{
    return this.httpClient.post<Produto>(`${this.URL_API}/produto`, produto)
  }
  public atualizar(produto: Produto, id: number): Observable<Produto>{
    return this.httpClient.put<Produto>(`${this.URL_API}/${id}/atualizar`, produto)
  }
}
