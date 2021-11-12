import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/customer';

import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer [] = [];

  constructor(private customerService: CustomerService ) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.customerService.getCustomers().subscribe(data => {
      this.customers = data;
    })
  }



}
