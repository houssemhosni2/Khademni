import {Component, OnInit} from '@angular/core';
import {Enterprise} from "../models/enterprise";
import {EnterpriseService} from "../services/enterprise.service";

@Component({
  selector: 'app-enterprise',
  templateUrl: './enterprise.component.html',
  styleUrls: ['./enterprise.component.css']
})
export class EnterpriseComponent implements OnInit{

  enterprises: Enterprise[] = [];

  constructor(private enterpriseService: EnterpriseService) { }

  ngOnInit(): void {
    this.getEnterprises();
  }

  getEnterprises(): void {
    this.enterpriseService.getEnterprises()
      .subscribe(enterprises => this.enterprises = enterprises);
  }

  addEnterprise(enterprise: Enterprise): void {
    this.enterpriseService.addEnterprise(enterprise)
      .subscribe(newEnterprise => {
        this.enterprises.push(newEnterprise);
      });
  }

  updateEnterprise(enterprise: Enterprise): void {
    this.enterpriseService.updateEnterprise(enterprise)
      .subscribe(updatedEnterprise => {
        const index = this.enterprises.findIndex(e => e.id === updatedEnterprise.id);
        if (index !== -1) {
          this.enterprises[index] = updatedEnterprise;
        }
      });
  }

  deleteEnterprise(id: number): void {
    this.enterpriseService.deleteEnterprise(id)
      .subscribe(() => {
        this.enterprises = this.enterprises.filter(e => e.id !== id);
      });
  }
}
