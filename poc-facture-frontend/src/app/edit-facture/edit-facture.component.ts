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
          libelle : this.formBuilder.control(facture.libelle , [Validators.required]),
          montant : this.formBuilder.control(facture.montant, [Validators.min(10)]),
          client  : this.formBuilder.control(facture.client , [Validators.required])
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
