import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FacturesComponent } from './Factures/factures.component';
import { NouveauFactureComponent } from './nouveau-facture/nouveau-facture.component';

// Injecting http client module in the angular application.
import { HttpClientModule } from '@angular/common/http';
import { FactureService } from './services/facture.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NouveauFactureComponent,
    FacturesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
   
  ],
  
  providers: [FactureService],
  bootstrap: [AppComponent]
})
export class AppModule { }
