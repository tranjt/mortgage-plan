import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CustomersComponent } from './component/customers/customers.component';
import { MortgageCalculatorComponent } from './component/mortgage-calculator/mortgage-calculator.component';


const routes: Routes = [
  { path: 'customers', component: CustomersComponent },
  { path: 'loanCalculator', component: MortgageCalculatorComponent },
  { path: '**', redirectTo: '/customers' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
