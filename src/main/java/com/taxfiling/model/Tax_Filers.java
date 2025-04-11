package com.taxfiling.model;

/**
 * Model class for Tax Filers
 */
public class Tax_Filers {
    private int filerId;
    private String name;
    private String contact;
    private double annualIncome;
    private double expenses;
    private int taxYear;
    
    // Default constructor
    public Tax_Filers() {
    }
    
    // Parameterized constructor
    public Tax_Filers(int filerId, String name, String contact, double annualIncome, double expenses, int taxYear) {
        this.filerId = filerId;
        this.name = name;
        this.contact = contact;
        this.annualIncome = annualIncome;
        this.expenses = expenses;
        this.taxYear = taxYear;
    }
    
    // Constructor without filerId for create operations
    public Tax_Filers(String name, String contact, double annualIncome, double expenses, int taxYear) {
        this.name = name;
        this.contact = contact;
        this.annualIncome = annualIncome;
        this.expenses = expenses;
        this.taxYear = taxYear;
    }

    // Getters and Setters
    public int getFilerId() {
        return filerId;
    }

    public void setFilerId(int filerId) {
        this.filerId = filerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public int getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }
    
    // Calculate taxable income (income - expenses)
    public double getTaxableIncome() {
        return this.annualIncome - this.expenses;
    }

    @Override
    public String toString() {
        return "Tax_Filers [filerId=" + filerId + ", name=" + name + ", contact=" + contact + ", annualIncome="
                + annualIncome + ", expenses=" + expenses + ", taxYear=" + taxYear + "]";
    }
}
