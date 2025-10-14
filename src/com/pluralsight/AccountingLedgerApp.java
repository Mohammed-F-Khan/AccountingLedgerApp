package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

// main class that runs the acconting ledger app
public class AccountingLedgerApp {

    // Array list to hold all transaction objects and since its static it's shared across all methods.
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // main method where the program starts running.
    public static void main(String[] args) {

        // first shows welcome screen
        displayWelcomeScreen();

        // scanner to get user input
        Scanner scanner = new Scanner(System.in);
    }
    // this method shows the welcome screen
    // Box Drawings found oun w3schools.com - https://www.w3schools.com/charsets/ref_utf_box.asp
    public static void displayWelcomeScreen() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                                                        ║");
        System.out.println("║            ACCOUNTING LEDGER APPLICATION               ║");
        System.out.println("║           Track Your Financial Transactions            ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    // homescreen method, it displays the main menu and also a sccanner to read user input.
    public static void homeScreen(Scanner scanner) {
        // while loop keeps running until the user chooses exit
        while (true) {
            // main menu.
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│              HOME SCREEN               │");
            System.out.println("├────────────────────────────────────────┤");
            System.out.println("│  D) Add Deposit                        │");
            System.out.println("│  P) Make Payment (Debit)               │");
            System.out.println("│  L) Ledger                             │");
            System.out.println("│  X) Exit                               │");
            System.out.println("└────────────────────────────────────────┘");
            System.out.print("Enter your choice: ");

            // this reads the user's choice and toUpperCase() converts the choice to upper case
            String choice = scanner.nextLine().toUpperCase();

            // Switch statement to check the user's choice and run the right code.
            switch (choice) {
                case "D":
                    // if user chooses D, run the addDeposit method and then the scanner
                    addDeposit(scanner);
                    break; // exit the switch statement
                case "P":
                    // if user chooses P, run the make payment method and then the scanner.
                    makePayment(scanner);
                    break; // exit the switch statement
                case "L":
                    // if user chooses L, run the ledger screen method and then the scanner
                    ledgerScreen(scanner);
                    break; //exit the switch statement
                case "X":
                    // if user chose X, show goodbye message and exit
                    System.out.println("\n╔════════════════════════════════════════════╗");
                    System.out.println("║  Thank you for using Accounting Ledger!      ║");
                    System.out.println("║  Your data has been saved.                   ║");
                    System.out.println("╚══════════════════════════════════════════════╝");
                    return;  // this exits the method and ends the program.
                default:
                    // if user types something else, show error message
                    System.out.println("invalid choice. Please try again. \n");
            }
        }
    }

    // addDeposit method - this method handles adding a new deposit (money coming inn)
    // scanner so it can read user input
    public static void addDeposit(Scanner scanner) {
        System.out.println("\n═══ ADD DEPOSIT ═══");

        // ask user for the date
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        // LocalDate.parse -  turns text into a date that java can understand, converts the text into an actual date
        LocalDate date = LocalDate.parse(dateInput);

        // ask user for time
        System.out.print("enter time (HH:mm:ss): ");
        String timeInput = scanner.nextLine();
        // LocalTime.parse converts the string into a LocalTime object
        LocalTime time = LocalTime.parse(timeInput);

        // Get the description of what this deposit is for.
        System.out.print("Enter description:");
        String description = scanner.nextLine();

        // get the vendor name who gave the money
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        // This creates a new transaction object with all the information that has been collected
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        // this adds the transaction to the ArrayList
        transactions.add(transaction);


        // Shows a message that the deposit was successful!
        System.out.println("✓ Deposit added successfully!\n");
    }
}
