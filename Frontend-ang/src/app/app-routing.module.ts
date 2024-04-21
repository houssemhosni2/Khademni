import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {OfferComponent} from "./offer/offer.component";
import {EtudiantComponent} from "./etudiant/etudiant.component";
import {EnterpriseComponent} from "./enterprise/enterprise.component";
import {CompetenceComponent} from "./competence/competence.component";
import {BusinessAreaComponent} from "./business-area/business-area.component";
import {NotfoundComponent} from "./notfound/notfound.component";

const routes: Routes = [
  {path : "", redirectTo: "home", pathMatch : "full" },
  {path : "home", component : HomeComponent },
  {path : "offer", component : OfferComponent },
  {path : "etudiant", component : EtudiantComponent },
  {path : "enterprise", component : EnterpriseComponent },
  {path : "competence", component : CompetenceComponent },
  {path : "businessArea", component : BusinessAreaComponent },
  {path : "**", component : NotfoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
