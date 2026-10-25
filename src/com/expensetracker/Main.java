package com.expensetracker;
import com.expensetracker.model.Expense;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Expense expense1 = new Expense("lunch", 480, "monthly dinner");

        Expense expense2 = new Expense("Petrol", 220, "weekly expense", LocalDate.of(2026, 10, 24));

        System.out.println(expense2);
        System.out.println(expense2.getAmount());
    }
}