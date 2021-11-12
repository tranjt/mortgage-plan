package com.tranjt.mortgageplan.service;

import com.tranjt.mortgageplan.dto.LoanCalcResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoanCalculatorServiceTest {

    @Autowired
    private LoanCalculatorService loanCalculatorService;

    @Test
    void shouldReturnLoanCalculation() {
        double totalLoan = 1000;
        double interest = 5;
        int years = 2;

        LoanCalcResponseDTO expected = new LoanCalcResponseDTO(
                43.871389734068096,
                1052.9133536176344,
                52.91335361763436,
                24
        );

        LoanCalcResponseDTO result = loanCalculatorService.getLoanCalculation(totalLoan, interest, years);

        Assertions.assertEquals(expected, result);
    }
}