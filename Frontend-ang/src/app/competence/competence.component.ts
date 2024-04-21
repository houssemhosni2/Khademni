import {Component, OnInit} from '@angular/core';
import {Competence} from "../models/competence";
import {CompetenceService} from "../services/competence.service";

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit{
  competences: Competence[] = [];

  constructor(private competenceService: CompetenceService) { }

  ngOnInit(): void {
    this.getCompetences();
  }

  getCompetences(): void {
    this.competenceService.getCompetences()
      .subscribe(competences => this.competences = competences);
  }
}
