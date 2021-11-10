package com.tranjt.mortgageplan.utils;

import org.springframework.stereotype.Component;

@Component("mortgageCalculator")
public class MortgageCalculator {

    public double calculateMonthlyPayment(double interest, double totalLoan, int year) {
        double monthlyInterest = interest / (12*100);
        int numberOfPayment = year * 12;

        return (totalLoan * monthlyInterest * power(1 + monthlyInterest, numberOfPayment))
                / (power(1 + monthlyInterest, numberOfPayment) - 1);
    }

    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double result = power(base, exponent / 2);
        result = result * result;
        if (exponent % 2 != 0) {
            result = result * base;
        }
        return result;
    }

}