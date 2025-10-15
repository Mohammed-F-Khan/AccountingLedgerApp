package com.pluralsight;

import java.io.*;
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

        // Loads existing transactions from the CSV file
        loadTransactions();

        // scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Show the home screen menu and pass the scanner to it
        homeScreen(scanner);
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
                    System.out.println("║  Thank you for using Accounting Ledger!   ║");
                    System.out.println("║  Your data has been saved.                ║");
                    System.out.println("╚════════════════════════════════════════════╝");
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
        System.out.print("Enter description: ");
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

        // save this transaction to the CSV file so it's stored permanently
        saveTransaction(transaction);

        // Shows a message that the deposit was successful!
        System.out.println("✓ Deposit added successfully!\n");
    }

    // This method handles making a payment (money going out unlike addDesposit
    public static void makePayment(Scanner scanner) {
        System.out.println("\n═══ MAKE PAYMENT ═══");

        // Get the date of the payment
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput);

        // Get the time of the payment
        System.out.print("Enter time (HH:mm:ss): ");
        String timeInput = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeInput);

        // Get what this payment was for
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        // Get who received the payment
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();

        // Get the amount paid
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        // Made the amount negative because payments are money going out
        // Math.abs() makes sure it's positive first, then I added the minus sign
        amount = -Math.abs(amount);

        // this Creates the transaction object again and adds it to our list
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        transactions.add(transaction);
        // Save it to the file
        saveTransaction(transaction);

        System.out.println("✓ Payment recorded successfully!\n");
    }

    // This method saves a single transaction to the CSV file
    public static void saveTransaction(Transaction transaction) {
        try {
            // Filerwriter opens or creates the file
            // true means it adds to the end instead of overwriting
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // bufferedwriter makes writing more efficient
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // String.format makes it into a formatted string with the data
            // %s means string, %.2f means decimal with 2 decimal places.
            String line = String.format("%s|%s|%s|%s|%.2f\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            // this writes the line to the file
            bufferedWriter.write(line);
            //closes the writer to save the changes
            bufferedWriter.close();
        } catch (IOException e) {
            // this shows an error if something goes wrong
            System.out.println("ERROR: Could not save transaction!");
            e.printStackTrace(); // prints detailed error information
        }
    }

    // This method reads all transactions from the CSV file when the program starts
    public static void loadTransactions() {
        try {
            //opens the file for reading
            FileReader fileReader = new FileReader("transactions.csv");
            // reads the line, line by line
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // it reads line by line, and returns null if no more lines are there
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                //parse each part into the correct data type
                LocalDate date = LocalDate.parse(parts[0]); // first part is the date
                LocalTime time = LocalTime.parse(parts[1]); // second part is time
                String description = parts[2];              // third part is description
                String vendor = parts[3];                   // fourth part is vendor
                double amount = Double.parseDouble(parts[4]); // fifth part is amount

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                // add it to our ArrrayList
                transactions.add(transaction);
            }
            //close the reader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("No existing transactions file found. Starting fresh.");
        }
    }

    // This method shows the ledger menu, and then passes it to the scanner.
    public static void ledgerScreen(Scanner scanner) {
        while (true) {
            System.out.println("\n┌────────────────────────────────────────┐");
            System.out.println("│           LEDGER                       │");
            System.out.println("├────────────────────────────────────────┤");
            System.out.println("│  A) All Entries                        │");
            System.out.println("│  D) Deposits                           │");
            System.out.println("│  P) Payments                           │");
            System.out.println("│  R) Reports                            │");
            System.out.println("│  H) Home                               │");
            System.out.println("└────────────────────────────────────────┘");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    // shows all the transactions
                    displayAllEntries();
                    break;
                case "D":
                    // show only deposits
                    displayDeposits();
                    break;
                case "P":
                    //show only payments
                    displayPayments();
                    break;
                case "R":
                    // go to the reports menu and pass the scanner
                    reportsScreen(scanner);
                    break;
                case "H":
                    // Return to home screen
                    return;
                default:
                    System.out.println("invalid choice. Please try again.");
            }
        }
    }

    // this method display all transactions sorted by date (newest first)
    public static void displayAllEntries() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                 ALL ENTRIES");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════");

        //print f formats the output in colums
        // %-12 means left alligned string with 12 characters width and %10 means right aligned with 10 char width
        System.out.printf("%-12s %-10s %-25s %-20s %10s\n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------");

        // this creats a copy of the transaction list so the orignal isn't lost
        ArrayList<Transaction> sortedTransactions = new ArrayList<Transaction>(transactions);

        for (int i = 0; i < sortedTransactions.size() - 1; i++) {
            // Inner loop compares adjacent items
            for (int j = 0; j < sortedTransactions.size() - i - 1; j++) {
                // isBefore() checks if the first date is before the second date
                // If it is, we swap them so newer dates come first
                if (sortedTransactions.get(j).getDate().isBefore(sortedTransactions.get(j + 1).getDate())) {
                    // Swapping - save one transaction temporarily
                    Transaction temp = sortedTransactions.get(j);
                    // Move the second transaction to the first position
                    sortedTransactions.set(j, sortedTransactions.get(j + 1));
                    // Put the saved transaction in the second position
                    sortedTransactions.set(j + 1, temp);
                }
            }
        }

        // Enhanced for loop (for-each) goes through each transaction
        for (Transaction transaction : sortedTransactions) {
            // Display each transaction in formatted columns
            System.out.printf("%-12s %-10s %-25s %-20s %10.2f\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════\n");
    }
    // This method displays only deposits
    public static void displayDeposits() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════");
        System.out.println("                              DEPOSITS ONLY");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-10s %-25s %-20s %10s\n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------");

        // this new list only holds deposits
        ArrayList<Transaction> deposits = new ArrayList<Transaction>();

        // Filter: this like a filter that loops through all transactions and only adds the positive ones
        for (Transaction transaction : transactions) {
            // If amount is greater than 0, it's a deposit
            if (transaction.getAmount() > 0) {
                deposits.add(transaction);
            }
        }
        // Sorts the deposits by date (newest first) using bubble sort
        for (int i = 0; i < deposits.size() - 1; i++) {
            for (int j = 0; j < deposits.size() - i - 1; j++) {
                if (deposits.get(j).getDate().isBefore(deposits.get(j + 1).getDate())) {
                    Transaction temp = deposits.get(j);
                    deposits.set(j, deposits.get(j + 1));
                    deposits.set(j + 1, temp);
                }
            }
        }

        // Displays each deposit
        for (Transaction transaction : deposits) {
            System.out.printf("%-12s %-10s %-25s %-20s %10.2f\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════\n");
    }

    // This method displays only payments (negative amounts)
    public static void displayPayments() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════");
        System.out.println("                              PAYMENTS ONLY");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-10s %-25s %-20s %10s\n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("-------------------------------------------------------------------------------");

        // a new list that holds only payments
        ArrayList<Transaction> payments = new ArrayList<Transaction>();

        // Filter: another filter that loops through all transactions and only adds the negative ones
        for (Transaction transaction : transactions) {
            // If amount is less than 0, it's a payment
            if (transaction.getAmount() < 0) {
                payments.add(transaction);
            }
        }

        // Sorts the payments by date (newest first) using bubble sort
        for (int i = 0; i < payments.size() - 1; i++) {
            for (int j = 0; j < payments.size() - i - 1; j++) {
                if (payments.get(j).getDate().isBefore(payments.get(j + 1).getDate())) {
                    Transaction temp = payments.get(j);
                    payments.set(j, payments.get(j + 1));
                    payments.set(j + 1, temp);
                }
            }
        }

        // Displays each payment
        for (Transaction transaction : payments) {
            System.out.printf("%-12s %-10s %-25s %-20s %10.2f\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════\n");
    }
}