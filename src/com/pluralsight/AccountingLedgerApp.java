package com.pluralsight;

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
}
