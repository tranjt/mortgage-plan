import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Customer } from '../model/customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseURL}/api/mortgage-plan/customers`);
  }
  
}
