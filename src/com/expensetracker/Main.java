package com.expensetracker;
import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ExpenseService service = new ExpenseService();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            showMenu();

            int choice = readIntInput(" Enter choice: ");

            switch(choice) {
                case 1:
                    addExpenseFlow();
                    break;
                case 2:
                    viewExpenseFlow();
                    break;
                case 3:
                    viewTotalFlow();
                    break;
                case 4:
                    running = false;
                    System.out.println("Good Bye ...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1 to 4");
            }
        }

        scanner.close();
    }

    private static void addExpenseFlow() {
        System.out.println("\n Add new Expense");

        // Read amount
        double amount = readDoubleInput(" Amount : ");

        // Read category
        System.out.print("  Category (Food/Travel/Bills/Health/Other): ");
        String category = scanner.nextLine().trim();

        // Read Notes
        String notes = scanner.nextLine().trim();

        boolean success = service.addExpense(category, amount, notes);

        if(success) {
            System.out.println(" Expense added successfully...");
        }
    }

    private static void showMenu() {
        System.out.println("\n┌─────────────────────────┐");
        System.out.println("│         MENU            │");
        System.out.println("├─────────────────────────┤");
        System.out.println("│  1. Add Expense         │");
        System.out.println("│  2. View All Expenses   │");
        System.out.println("│  3. View Total          │");
        System.out.println("│  4. Exit                │");
        System.out.println("└─────────────────────────┘");
    }

    private static void viewExpenseFlow() {
        System.out.println(" All Expenses");
        service.viewAllExpense();
    }

    private static void viewTotalFlow() {
        System.out.println("\n --- Summary --- ");
        System.out.println(" Total expense: " + service.getExpenseCount());
        System.out.println(" Total spent: " + service.getTotalSpent());
    }

    private static int readIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);

            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(" Invalid input. Please enter a number.");
            }
        }
    }

    private static double readDoubleInput(String prompt) {
        while (true) {
            System.out.println(prompt);

            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(" Invalid amount. Enter a number like 500 or 99.50");
            }
        }
    }
}