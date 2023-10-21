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
  protected submitted = false;

  constructor(private formBuilder: FormBuilder , 
              private factureService :FactureService){
  }

  ngOnInit(): void {
    this.factureForm=this.formBuilder.group({
      customerRef : this.formBuilder.control('',[Validators.required]),
      customerContact : this.formBuilder.control('',[Validators.required, Validators.email]),
      dueDate  : this.formBuilder.control('',[Validators.required]),
      emissionDate  : this.formBuilder.control('',[Validators.required]),
      prestation :this.formBuilder.group({
        description : this.formBuilder.control('',[Validators.required]),
        quantity : this.formBuilder.control(0),
        unitPrice : this.formBuilder.control(0),
        unit : this.formBuilder.control('',[Validators.required]),
        vATRate : this.formBuilder.control(0),
        prestationDate : this.formBuilder.control('',[Validators.required])
      })
    });
 
  }

  ajouterFacture(){
    this.submitted = true;
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
    
    console.log('customerRef', this.factureForm.value.customerRef);
    console.log('customerContact', this.factureForm.value.customerContact);
    console.log('dueDate', this.factureForm.value.dueDate);
    console.log('emissionDate', this.factureForm.value.emissionDate);
  }
}
