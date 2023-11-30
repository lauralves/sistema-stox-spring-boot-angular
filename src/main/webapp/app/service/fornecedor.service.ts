import {Injectable} from "@angular/core";
import {enviroment} from "../enviroments/enviroment";
import {HttpClient} from "@angular/common/http";
import {FornecedorListView} from "../domain/fornecedor-list-view";
import {Observable} from "rxjs";

@Injectable({
  providedIn: "root"
  })

export class FornecedorService {
  URL_API: string = `${enviroment.contextPath}/api/fornecedor`

  constructor(protected httpClient: HttpClient) {
  }

  public createFornecedor(fornecedor: FornecedorListView): Observable<FornecedorListView>{
    return this.httpClient.post<FornecedorListView>(`${this.URL_API}`, fornecedor)
  }
}
