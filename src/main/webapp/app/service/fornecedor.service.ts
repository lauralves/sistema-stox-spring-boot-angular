import {Injectable} from "@angular/core";
import {enviroment} from "../enviroments/enviroment";
import {HttpClient} from "@angular/common/http";
import {FornecedorListView} from "../domain/fornecedor-list-view";
import {catchError, map, Observable, throwError} from "rxjs";
import {Page} from "../@core/types/page";

@Injectable({
  providedIn: "root"
  })

export class FornecedorService {
  URL_API: string = `${enviroment.contextPath}/api/fornecedor`

  constructor(protected httpClient: HttpClient) {
  }

  public findAll<T>(): Observable<{data: T[]; totalCount: number}> {
    return this.httpClient.get<Page<T>>(`${this.URL_API}`)
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

  public createFornecedor(fornecedor: FornecedorListView): Observable<FornecedorListView>{
    return this.httpClient.post<FornecedorListView>(`${this.URL_API}`, fornecedor)
  }
  public deleteFornecedor(id: number): Observable<FornecedorListView>{
    return this.httpClient.delete<FornecedorListView>(`${this.URL_API}/${id}`)
  }
}
