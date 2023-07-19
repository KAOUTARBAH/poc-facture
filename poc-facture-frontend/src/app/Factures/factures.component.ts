import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { facture } from '../shared/facture';

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css'],
})
export class FacturesComponent implements OnInit {
  factures: facture[] = [];

  private factureURL = 'http://localhost:8098/facture/allFacture';

  constructor(private client: HttpClient) {}

  ngOnInit(): void {
    console.log('Initialisation du controleur du compasant afficher factures');
    this.getFactures(); //faire appele de méthode ci dessous.
  }

  //méthode pour récupérer la liste des factures depuis API Rest
  getFactures() {
    //this.client.get<any>(this.factureURL).subscribe
    //        (response => {console.log(response);
    //                     this.factures= response; });

    this.client.get<any>(this.factureURL).subscribe({
      next: (data) => {
        this.factures = data;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  /*handleCheckFacture(facture: any){
    this.http.patch<any>(`http://localhost:8089/factures/${facture.id}`,
      {checked:!facture.checked}).subscribe({
        next:updatedFacture => {
          facture.checked=!facture.checked;
          //this.getFactures();
        }
      })
     
  }
  */
}
