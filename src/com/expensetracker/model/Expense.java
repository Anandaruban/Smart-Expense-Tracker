package com.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private String category;
    private double amount;
    private String notes;
    private LocalDate date;

    public Expense(String category, double amount, String notes) {
        this.amount = amount;
        this.notes = notes;
        this.category = category;
        this.date = LocalDate.now();
    }

//    compile-time polymorphism
    public Expense(String category, double amount, String notes, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.notes = notes;
        this.date = date;
    }

//    getters
    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return category + " " + amount + " " + notes + " " + date;
    }
}