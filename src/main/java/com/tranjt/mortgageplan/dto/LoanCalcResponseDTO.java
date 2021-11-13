package com.tranjt.mortgageplan.dto;

import java.util.Objects;

public class LoanCalcResponseDTO {

    double monthlyPayment;
    double totalPayment;
    double totalInterest;
    int payments;

    public LoanCalcResponseDTO(double monthlyPayment, double totalPayment, double totalInterest, int payments) {
        this.monthlyPayment = monthlyPayment;
        this.totalPayment = totalPayment;
        this.totalInterest = totalInterest;
        this.payments = payments;

    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanCalcResponseDTO that = (LoanCalcResponseDTO) o;
        return Double.compare(that.monthlyPayment, monthlyPayment) == 0 && Double.compare(that.totalPayment, totalPayment) == 0 && Double.compare(that.totalInterest, totalInterest) == 0 && payments == that.payments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyPayment, totalPayment, totalInterest, payments);
    }
}
