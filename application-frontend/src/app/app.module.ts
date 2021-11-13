import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomersComponent } from './component/customers/customers.component';
import { MortgageCalculatorComponent } from './component/mortgage-calculator/mortgage-calculator.component';
import { CalcResultComponent } from './component/calc-result/calc-result.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomersComponent,
    MortgageCalculatorComponent,
    CalcResultComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
