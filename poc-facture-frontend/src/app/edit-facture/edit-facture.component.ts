import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FactureService } from '../services/facture.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Facture } from '../model/facture.model';

@Component({
  selector: 'app-edit-facture',
  templateUrl: './edit-facture.component.html',
  styleUrls: ['./edit-facture.component.css']
})
export class EditFactureComponent implements OnInit {
  factureId! :number;
  factureFormGroup! : FormGroup;

  constructor(private activateRoute : ActivatedRoute,
              private factureService : FactureService ,
              private formBuilder : FormBuilder){
  }

  ngOnInit() {
    this.factureId = this.activateRoute.snapshot.params['id'];
    this.factureService.getFactureById(this.factureId).subscribe({
      next : (facture)=> {
        this.factureFormGroup = this.formBuilder.group({
          id : this.formBuilder.control(facture.id),
          customerRef : this.formBuilder.control(facture.customerRef , [Validators.required]),
          customerContact : this.formBuilder.control(facture.customerContact, [Validators.min(16)]),
          dueDate  : this.formBuilder.control(facture.dueDate),
          emissionDate  : this.formBuilder.control(facture.emissionDate , [Validators.required]),
          prestation :this.formBuilder.group({
            description  : this.formBuilder.control(facture.prestation.description , [Validators.required]),
            quantity  : this.formBuilder.control(facture.prestation.quantity , [Validators.required]),
            unitPrice :this.formBuilder.control(facture.prestation.unitPrice , [Validators.required]),
            vATRate : this.formBuilder.control(facture.prestation.VATRate,[Validators.required]),
            prestationDate : this.formBuilder.control(facture.prestation.prestationDate)
          })
        });
      },
     
      error : error =>{
        console.error();
      }
    });
  }

  updateFacture(){
    let facture :Facture = this.factureFormGroup.value;
    this.factureService.updateFacture(facture).subscribe({
      next :data =>{
        alert(JSON.stringify(data));
      },
      error: error =>{
        console.error();
      }
    });
  }

}
