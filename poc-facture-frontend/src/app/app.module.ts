import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FacturesComponent } from './Factures/factures.component';
import { NouveauFactureComponent } from './nouveau-facture/nouveau-facture.component';

// Injecting http client module in the angular application.
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FactureService } from './services/facture.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditFactureComponent } from './edit-facture/edit-facture.component';
import { LoginComponent } from './login/login.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { AppHttpInterceptor } from './interceptors/app-http.interceptor';
import { RegisterComponent } from './register/register.component';
import { PrestationComponent } from './prestation/prestation.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NouveauFactureComponent,
    FacturesComponent,
    EditFactureComponent,
    LoginComponent,
    AdminTemplateComponent,
    RegisterComponent,
    PrestationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
   
  ],
  
  providers: [FactureService,
            {
              provide : HTTP_INTERCEPTORS , useClass : AppHttpInterceptor, multi : true
            }],
  bootstrap: [AppComponent]
})
export class AppModule { }
