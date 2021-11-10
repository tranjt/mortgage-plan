package com.tranjt.mortgageplan.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CustomerRequestDTO {
    @NotNull
    @Size(min = 3, max = 30, message = "Name must be between 3-30 characters")
    private String name;

    @NotNull
    @Positive(message = "Total loan must be positive")
    private double totalLoan;

    @NotNull
    @Positive(message = "Interest must be positive")
    private double interest;

    @NotNull
    @Positive(message = "Years must be positive")
    private int years;

    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(String name, double totalLoan, double interest, int years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
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
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}

