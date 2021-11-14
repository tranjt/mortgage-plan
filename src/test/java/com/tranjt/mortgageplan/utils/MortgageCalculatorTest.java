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
    void calculateMonthlyPayment() {
        double interest = 5;
        double totalLoan = 1000;
        int year = 2;
        double expected = 43.871389734068096;

        double result = mortgageCalculator.calculateMonthlyPayment(totalLoan,interest, year);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void powerOfTwoNumbers() {
        double base = 4;
        int exponent = 2;
        double expected = 16;

        double result = mortgageCalculator.power(base, exponent);

        Assertions.assertEquals(expected, result);
    }
}