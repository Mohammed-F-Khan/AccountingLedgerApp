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
}
