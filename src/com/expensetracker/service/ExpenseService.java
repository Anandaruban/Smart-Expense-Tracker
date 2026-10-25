package com.expensetracker.service;

import com.expensetracker.model.Expense;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public boolean addExpense(String category, double amount, String notes) {

        if(amount <= 0) {
            System.out.println("Amount must be grater than zero");
            return false;
        }

        if(category == null || category.trim().isEmpty()) {
            System.out.println("Category cannot be empty");
            return false;
        }

        if(notes.trim().isEmpty() || notes == null) {
            System.out.println("Notes cannot be empty");
            return false;
        }

        Expense expense = new Expense(category.trim(), amount, notes.trim());
        expenses.add(expense);
        return true;
    }

    public void viewAllExpense() {
        if(expenses.isEmpty()) {
            System.out.println("No expenses yet");
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {
            System.out.printf("  %-3d %s%n", (i + 1), expenses.get(i));
        }
    }

    public double getTotalSpent() {
        double total = 0;

        for(Expense expense: expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public int getExpenseCount() {
        return expenses.size();
    }
}