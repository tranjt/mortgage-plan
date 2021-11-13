import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { LoanCalculation } from '../model/loanCalc';
import { Loan } from '../model/loan';


@Injectable({
  providedIn: 'root'
})
export class MortgageCalculatorService {

  private baseURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }


  getLoanCalculation(loan: Loan): Observable<LoanCalculation> {
    const params = new HttpParams()
      .set("totalLoan", loan.totalLoan)
      .set("interest", loan.interest)
      .set("years", loan.years);

    return this.http.get<LoanCalculation>(`${this.baseURL}/api/mortgage-plan/calculate-loan`, { params: params });
  }

}
