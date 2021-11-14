import { Component, OnInit } from '@angular/core';

import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';


@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer[] = [];
  errorMessage: string = "";

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.customerService.getCustomers().subscribe({
      next: data => {
        this.customers = data;
        console.log(this.customers);
      },
      error: err => {
        this.handleError(err);
      }
    })
  }

  handleError(err: any): void {
    if (err.status === 0) {
      this.showErrorMessage("Status: 0, Request did not succeed");
    }
    else {
      this.showErrorMessage(err.error.message);
    }
    console.log(err);
  }

  showErrorMessage(errorMessage: string): void {
    this.errorMessage = errorMessage;
    setTimeout(() => {
      this.errorMessage = "";
    }, 5000);
  }

}
