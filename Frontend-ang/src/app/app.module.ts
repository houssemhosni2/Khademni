import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { CompetenceComponent } from './competence/competence.component';
import { OfferComponent } from './offer/offer.component';
import { EnterpriseComponent } from './enterprise/enterprise.component';
import { BusinessAreaComponent } from './business-area/business-area.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent,
    CompetenceComponent,
    OfferComponent,
    EnterpriseComponent,
    BusinessAreaComponent,
    HomeComponent,
    NotfoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
