import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Facture } from '../model/facture.model';

@Injectable({
  providedIn: 'root',
})
export class FactureService {
  constructor(private http: HttpClient) {}
  public API_URL : string = "http://localhost:8098/api/v1/invoices";
  
  getFacturesPage(page: number = 1, size: number = 4) {  
    return this.http.get(
      `${this.API_URL}/?page=${page}&size=${size}`,{observe:'response'}
    );
  }

  getFacturesParPage(keyword: string ="", page: number = 1, size: number = 4) :Observable<any> {
    // return this.http.get(API_URLS.factures_URL);
    return this.http.get<Array<Facture>>(
      `${this.API_URL}/KeywordByPage?mc=${keyword}&page=${page}&size=${size}`
    );
  }

  getFactures(page: number = 1, size: number = 4): Observable<Array<Facture>> {    
    return this.http.get<Array<Facture>>(
      `${this.API_URL}/?page=${page}&size=${size}`
    );
  }


  /*
     getFacturesParPage(page: number = 1, size: number = 4) :Observable<any> {
    // return this.http.get(API_URLS.factures_URL);
    return this.http.get<Array<Facture>>(
      `${this.API_URL}/invoicesByPage?page=${page}&size=${size}`
    );
  }
  */
  


  deleteFacture(facture: Facture) {
    return this.http.delete(`${this.API_URL}/delete/${facture.id}`);
  }

  ajouterFacture(facture: Facture): Observable<Facture> {
    return this.http.post<Facture>(`${this.API_URL}/create`, facture);
  }

  rechercheFactures(keyword: string): Observable<Array<Facture>> {
    return this.http.get<Array<Facture>>(
      `${this.API_URL}/keyword?mc=${keyword}`
      
    );
  }

  rechercheFacturesByPage(keyword: string ="", page: number = 1, size: number = 4): Observable<any> {
    return this.http.get<Array<Facture>>(
      `${this.API_URL}/KeywordByPage?mc=${keyword}&page=${page}&size=${size}`
      
    );
  }

  getFactureById(factureId: number) : Observable<Facture> {
      return this.http.get<Facture>(`${this.API_URL}/invoice/${factureId}`)
  }

  updateFacture(facture: Facture) : Observable<Facture> {
    return this.http.put<Facture>(`${this.API_URL}/update`,facture)  
  }

  
}
