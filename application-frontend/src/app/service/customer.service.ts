import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Customer } from '../model/customer';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL = 'http://localhost:8080';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }


  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseURL}/api/mortgage-plan/customers`);

  }


}
