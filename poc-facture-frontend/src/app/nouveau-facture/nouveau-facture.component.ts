import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FactureService } from '../services/facture.service';
import { Facture } from '../model/facture.model';

@Component({
  selector: 'app-nouveau-facture',
  templateUrl: './nouveau-facture.component.html',
  styleUrls: ['./nouveau-facture.component.css']
})
export class NouveauFactureComponent implements OnInit {
  
  public factureForm!:FormGroup;

  constructor(private formBuilder: FormBuilder , 
              private factureService :FactureService){
  }

  ngOnInit(): void {
    this.factureForm=this.formBuilder.group({
      libelle : this.formBuilder.control('',[Validators.required]),
      montant : this.formBuilder.control(0),
      client  : this.formBuilder.control('',[Validators.required]),
    });
 
  }

  ajouterFacture(){
    let facture : Facture = this.factureForm.value;
    this.factureService.ajouterFacture(facture)
    .subscribe({
      next : data => {
        alert(JSON.stringify(data));
      },
      error : err => {
        console.log(err);
      }
    });
    
    console.log('libelle', this.factureForm.value.libelle);
    console.log('montant', this.factureForm.value.montant);
    console.log('client', this.factureForm.value.client);
  }

  


  

}
