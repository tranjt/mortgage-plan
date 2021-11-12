package com.tranjt.mortgageplan.service;

import com.tranjt.mortgageplan.dto.LoanCalcResponseDTO;
import com.tranjt.mortgageplan.utils.MortgageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanCalculatorService {

    private MortgageCalculator mortgageCalculator;

    @Autowired
    public LoanCalculatorService(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public LoanCalcResponseDTO getLoanCalculation(double totalLoan, double interest, int years) {
        double monthlyPayment = mortgageCalculator.calculateMonthlyPayment(totalLoan, interest, years);
        int payments = years * 12;
        double totalPayment = monthlyPayment * payments;
        double totalInterest = totalPayment - totalLoan;

        return new LoanCalcResponseDTO(monthlyPayment, totalPayment, totalInterest, payments);
    }
}
