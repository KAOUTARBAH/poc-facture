import { Component } from '@angular/core';
import { Action } from 'rxjs/internal/scheduler/Action';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  actions :Array<any>=[
    {title :"Home", "route" : "/home", "icon" :"house"},
    {title :"Factures", "route" : "/factures","icon"  :"list"},
    {title :"Nouveau Facture", "route" : "/nouveauFacture", "icon" :"plus-circle"}
  ]

  currentAction :any;

  setCurrentAction(action :any){
    this.currentAction = action;
  }
}
