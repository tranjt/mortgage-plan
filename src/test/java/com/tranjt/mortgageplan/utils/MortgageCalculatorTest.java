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
    void testCalculateMonthlyPayment() {
        double interest = 5;
        double totalLoan = 1000;
        int year = 2;

        double result = mortgageCalculator.calculateMonthlyPayment(interest, totalLoan, year);

        double expected = 43.871389734068096;
        Assertions.assertEquals(expected, result);

    }

    @Test
    void testPower() {
        double base = 2;
        int exponent = 2;

        double result = mortgageCalculator.power(base, exponent);

        double expected = 4;
        Assertions.assertEquals(expected, result);
    }
}