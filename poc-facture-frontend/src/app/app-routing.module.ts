import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FacturesComponent } from './Factures/factures.component';
import { NouveauFactureComponent } from './nouveau-facture/nouveau-facture.component';

const routes: Routes = [
  {path :"" , component :FacturesComponent},
  {path :"home" , component : HomeComponent},
  {path :"factures" , component :FacturesComponent},
  {path :"nouveauFacture" , component : NouveauFactureComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }