import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable,throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'

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

    return this.http.get<LoanCalculation>(`${this.baseURL}/api/mortgage-plan/calculate-loan`, { params: params })
      .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse) {
    return throwError(() => error);
  }

}
