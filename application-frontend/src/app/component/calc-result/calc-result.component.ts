import { Component, OnInit, Input } from '@angular/core';

import { LoanCalculation } from 'src/app/model/loanCalc';

@Component({
  selector: 'app-calc-result',
  templateUrl: './calc-result.component.html',
  styleUrls: ['./calc-result.component.css']
})
export class CalcResultComponent implements OnInit {

  @Input() loanCalc: LoanCalculation | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
