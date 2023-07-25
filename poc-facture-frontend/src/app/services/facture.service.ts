import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


import { Facture } from '../model/facture.model';

@Injectable({
  providedIn: 'root'
})
export class FactureService {


  constructor(private http:HttpClient){
  }

   getFactures(page : number=1, size:number=4): Observable<Array<Facture>>{
    // return this.http.get(API_URLS.factures_URL);
    return this.http.get<Array<Facture>>(`http://localhost:8098/facture/allFacture?_page=${page}&_limit=${size}`);

  }

   deleteFacture(facture : Facture){
      //return this.http.delete<any>("http://localhost:8097/facture/${facture.id}");   
      return this.http.delete(`http://localhost:8098/facture/${facture.id}`);
    }

  
    ajouterFacture(facture : Facture) : Observable<Facture>{
      return this.http.post<Facture>(`http://localhost:8098/facture`
      ,facture);

    }

    rechercheFactures(keyword:string): Observable<Array<Facture>>{
      return this.http.get<Array<Facture>>(`http://localhost:8098/facture/libelle?mc=${keyword}`);
    }

 
}
