import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";
import {ProdutoListView} from "../domain/produto-list-view";
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
  public createProduto(produto: ProdutoListView): Observable<ProdutoListView>{
    return this.httpClient.post<ProdutoListView>(`${this.URL_API}/produto`, produto)
  }
  public atualizar(produto: ProdutoListView, id: number): Observable<ProdutoListView>{
    return this.httpClient.put<ProdutoListView>(`${this.URL_API}/${id}/atualizar`, produto)
  }
}
