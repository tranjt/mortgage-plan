package com.tranjt.mortgageplan.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MortgageCalculatorTest {

    @Autowired
    private MortgageCalculator mortgageCalculator;

    @Test
    void Calculate_monthly_payment() {
        double interest = 5;
        double totalLoan = 1000;
        int year = 2;
        double expected = 43.871389734068096;

        double result = mortgageCalculator.calculateMonthlyPayment(interest, totalLoan, year);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void Power_of_two_numbers() {
        double base = 4;
        int exponent = 2;
        double expected = 16;

        double result = mortgageCalculator.power(base, exponent);

        Assertions.assertEquals(expected, result);
    }
}