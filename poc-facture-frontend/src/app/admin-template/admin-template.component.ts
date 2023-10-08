import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrls: ['./admin-template.component.css']
})
export class AdminTemplateComponent implements OnInit {
  
  constructor(public authService: AuthService ,
              private router : Router) { }


  actions :Array<any>=[
    {title :"Home", "route" : "/admin/home", "icon" :"house"},
    {title :"Factures", "route" : "/admin/factures","icon"  :"list"},
    {title :"Nouveau Facture", "route" : "/admin/nouveauFacture", "icon" :"plus-circle"}
  ]

  currentAction :any;

  setCurrentAction(action :any){
    this.currentAction = action;
  }

  ngOnInit():void{
    this.router.navigateByUrl(`/admin/factures`);
  }

  login(){
    this.router.navigateByUrl(`/login`);
  }

  logout(){
    this.authService.logout();
    this.router.navigateByUrl(`/login`);
  }
}
