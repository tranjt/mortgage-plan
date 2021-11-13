import { Component, OnInit } from '@angular/core';


export class Loan {
  public totalLoan: number;
  public years: number;
  public interest: number;
}

@Component({
  selector: 'app-mortgage-calculator',
  templateUrl: './mortgage-calculator.component.html',
  styleUrls: ['./mortgage-calculator.component.css']
})
export class MortgageCalculatorComponent implements OnInit {

  submitted = false;
  model = new Loan();

  constructor() { }  

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.model);
    this.submitted = true;
  }
}
