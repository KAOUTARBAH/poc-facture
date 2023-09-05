import { HttpClient } from '@angular/common/http';
import { Component , OnInit  } from '@angular/core';
import { FactureService } from '../services/facture.service';
import { Facture } from '../model/facture.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

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
    public pageSize :number = 3;
    public totalElements: number=0;
    public totalPage: number=0;

    
    
    
    // private factureURL ='http://localhost:8097/facture/allFacture'; 


    constructor(private factureService:FactureService ,
                private router : Router){
    }

  ngOnInit():void{
    
    console.log("Initialisation du controleur du compasant afficher factures");
    //this.getFactures(); //faire appele de méthode ci dessous.
    this.getFactureParPage();
    //this.getFacturesPage();
  
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
    this.factureService.getFacturesParPage(this.keyword,this.currentPage, this.pageSize)
    .subscribe({
       next : data  => {
         this.factures = data.content;
         if (this.factures.length==0) {
          console.log ("PAS DES FACTURES A AFFICHER");
         }
         else
         {
          console.log(data.content);
          //console.log("*****************************");
          //console.log(this.factures);
          //console.log("*****************************");
          this.totalElements=data.totalElements;
          this.totalPage = data.totalPages;
          //console.log("Total pages: " +this.totalPage);
        
          this.totalPage = Math.floor(this.totalElements/ this.pageSize);
          if(this.totalElements % this.pageSize !=0){
            this.totalPage = this.totalPage+1 ; 
          }
          //console.log( "Total Pages: " +this.totalPage);
       

         }
         
       },
       error : err => {
         console.log(err);
       }
    })
  }

  getFacturesPage(){
    this.factureService.getFacturesPage(1,2)
    .subscribe({
       next : (resp) => {
         //this.factures = resp.body as Facture[];
         this.factures = resp.body as Facture[];
         let totalProducts:number=parseInt( resp.headers.get('x-total-count')!);
        
       },
       error : err => {
         console.log(err);
       }
    })
    // this.client.get<any>(this.factureURL).subscribe
    //         (response => {console.log(response);
    //                      this.factures= response; });
  }

  nextPage() {
   
    //if (this.currentPage < (this.factures?.length! / 3)) {
    // this.totalPage=(Math.floor(this.totalElements/ this.pageSize))
      if (this.currentPage  < (Math.floor(this.totalElements/ this.pageSize)) ) { 
    
     console.log("current Page : " +this.currentPage);
     console.log("totalPage: " +(Math.floor(this.totalElements/ this.pageSize)));

     if(this.totalElements % this.pageSize ==0){
       this.currentPage
     }
     this.currentPage++;
    //  console.log("current Page NEXT: " +this.curren=tPage);
      this.getFactureParPage();
      //this.rechercheFacturesByPage();

    }

  }

  prevPage() {

    if (this.currentPage > 0) {
      this.currentPage--;
      console.log(this.currentPage);
      this.getFactureParPage();
      //this.rechercheFacturesByPage();

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

  rechercheFacturesByPage(){
    this.currentPage  = 0;
    //this.totalElements = 0;
    this.totalPage=0;
    this.factureService.rechercheFacturesByPage(this.keyword,this.currentPage,  this.pageSize)
    
    .subscribe({
      next : value => 
      {
        this.factures =value.content;
        this.totalElements=value.totalElements;
        console.log("*****************************");
        console.log("le nombre de mot qui contient "+ this.keyword)
        console.log(this.totalElements);
        console.log(value.totalPages);
        console.log(this.totalElements/ this.pageSize);
        console.log("test facture RECHERCHE");
        // this.totalPage = Math.floor(this.totalElements/ this.pageSize);
        // if(this.totalElements % this.pageSize !=0){
        //   this.totalPage = this.totalPage+1 ; 
        // }
        
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

  handleGoToPage(page :number){
    this.currentPage = page;
    this.getFactureParPage();

  }

  handleEditFacture(facture :Facture){
    this.router.navigateByUrl(`/editFacture/${facture.id}`);
  }
 
}
