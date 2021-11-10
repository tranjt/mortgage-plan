package com.tranjt.mortgageplan.dto;


public class CustomerResponseDTO {

    private Long id;
    private String name;
    private double totalLoan;
    private double interest;
    private int years;
    private double fixedMonthlyPayment;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(Long id, String name, double totalLoan, double interest, int years, double fixedMonthlyPayment) {
        this.id = id;
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYears() {
        return this.years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }
}