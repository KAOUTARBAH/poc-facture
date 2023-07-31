import { HttpClient } from '@angular/common/http';
import { Component , OnInit  } from '@angular/core';
import { FactureService } from '../services/facture.service';
import { Facture } from '../model/facture.model';
import { CommonModule } from '@angular/common';

/* export class facture {
  constructor(public id : number ,
    public libelle: string ,
    public montant?: number ,
    public client?: string ){

  }
} */

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css']
})
export class FacturesComponent implements OnInit{

    public factures :Facture[] = [];
    public keyword : string = "";
    public currentPage :number = 0;
    
    
    
    // private factureURL ='http://localhost:8097/facture/allFacture'; 


    constructor(private factureService:FactureService){
    
    }

  ngOnInit():void{
    
    console.log("Initialisation du controleur du compasant afficher factures");
    this.getFactures(); //faire appele de méthode ci dessous.
    //this.getFactureParPage();
  
  }

  //méthode pour récupérer la liste des factures depuis API Rest
  getFactures(){
    this.factureService.getFactures(1,3)
    .subscribe({
       next : data => {
         this.factures = data
       },
       error : err => {
         console.log(err);
       }
    })
    // this.client.get<any>(this.factureURL).subscribe
    //         (response => {console.log(response);
    //                      this.factures= response; });
  }
  

  getFactureParPage(){
    //this.factureService.getFacturesParPage(this.currentPage, 3)
    this.factureService.getFacturesParPage(1, 3)
    .subscribe({
       next : data  => {
         this.factures = data;
          console.log(data);
          console.log("*****************************");
          console.log(this.factures);
        
       },
       error : err => {
         console.log(err);
       }
    })
  }

  

  nextPage() {

    if (this.currentPage < (this.factures?.length! / 3)) {
      this.currentPage++;
      this.getFactureParPage();

    }

  }

  prevPage() {

    if (this.currentPage > 0) {

      this.currentPage--;

      this.getFactureParPage();

    }

  }

  handleDeleteFacture(facture : Facture){
    if (confirm ("Etes vous sure ?"))
    this.factureService.deleteFacture(facture)
      .subscribe({
      next:value => {
        console.log("testtest facture delete");
      //  this.getFactures();
        this.factures = this.factures.filter(fact=>fact.id!=facture.id);
    }
    
  }
)
      
   }

  
  rechercheFactures(){
    this.factureService.rechercheFactures(this.keyword)
    .subscribe({
      next : value => 
      {
        this.factures =value;
        console.log("test facture RECHERCHE");
        
      }
    })

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
