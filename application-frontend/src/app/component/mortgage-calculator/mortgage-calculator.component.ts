import { Component, OnInit } from '@angular/core';

import { Loan } from 'src/app/model/loan';
import { LoanCalculation } from 'src/app/model/loanCalc';
import { MortgageCalculatorService } from 'src/app/service/mortgage-calculator.service';


@Component({
  selector: 'app-mortgage-calculator',
  templateUrl: './mortgage-calculator.component.html',
  styleUrls: ['./mortgage-calculator.component.css']
})
export class MortgageCalculatorComponent implements OnInit {

  submitted = false;
  loan = new Loan();
  loanCalc: LoanCalculation | undefined;
  errorMessage: string = "";

  constructor(private mortgageCalculatorService: MortgageCalculatorService) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.loan);
    this.submitted = true;
    this.getCalculations();
  }

  getCalculations(): void {
    this.mortgageCalculatorService.getLoanCalculation(this.loan).subscribe({
      next: data => {
        this.loanCalc = data;
        console.log(this.loanCalc);
      },
      error: err => {
        this.errorMessage = err.error.message
        console.log(err);
        console.log(this.errorMessage);
      }
    });
  }




}
