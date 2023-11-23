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
}
