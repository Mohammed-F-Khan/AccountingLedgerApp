Accounting Ledger Application
A command-line application for tracking financial transactions built with Java. This application allows users to manage deposits and payments, view transaction history, and generate detailed financial reports.
Features
Core Functionality

Add Deposits: Record income transactions with date, time, description, vendor, and amount
Make Payments: Record expense transactions (automatically stored as negative amounts)
View Ledger: Display all transactions sorted by date (newest first)
Filter by Type: View only deposits or only payments
Persistent Storage: All transactions are saved to and loaded from a CSV file

Reports

Month To Date: View all transactions from the beginning of the current month
Previous Month: View all transactions from the previous month
Year To Date: View all transactions from the beginning of the current year
Previous Year: View all transactions from the previous year
Search by Vendor: Find all transactions for a specific vendor
Custom Search: Advanced search with multiple filters (date range, description, vendor, amount)

Application Screenshots
Home Screen
╔════════════════════════════════════════════════════════╗
║                                                        ║
║     ACCOUNTING LEDGER APPLICATION                     ║
║     Track Your Financial Transactions                 ║
║                                                        ║
╚════════════════════════════════════════════════════════╝

┌────────────────────────────────────────┐
│           HOME SCREEN                  │
├────────────────────────────────────────┤
│  D) Add Deposit                        │
│  P) Make Payment (Debit)               │
│  L) Ledger                             │
│  X) Exit                               │
└────────────────────────────────────────┘
Ledger Screen
┌────────────────────────────────────────┐
│           LEDGER                       │
├────────────────────────────────────────┤
│  A) All Entries                        │
│  D) Deposits                           │
│  P) Payments                           │
│  R) Reports                            │
│  H) Home                               │
└────────────────────────────────────────┘
Reports Screen
┌────────────────────────────────────────┐
│           REPORTS                      │
├────────────────────────────────────────┤
│  1) Month To Date                      │
│  2) Previous Month                     │
│  3) Year To Date                       │
│  4) Previous Year                      │
│  5) Search by Vendor                   │
│  6) Custom Search                      │
│  0) Back                               │
└────────────────────────────────────────┘
Sample Transaction Display
═══════════════════════════════════════════════════════════════════════════════
ALL ENTRIES
═══════════════════════════════════════════════════════════════════════════════
Date         Time       Description               Vendor                  Amount
-------------------------------------------------------------------------------
2024-10-12   09:15:00   Client payment            Johnson LLC            1800.00
2024-10-10   15:45:00   Office supplies           Staples                 -75.25
2024-10-05   12:30:00   Consulting income         TechStart Inc          2500.00
2024-10-01   08:00:00   October rent              Property Management   -1200.00
═══════════════════════════════════════════════════════════════════════════════
How to Use
Setup

Clone this repository to your local machine
Open the project in your IDE (IntelliJ IDEA recommended)
Ensure you have Java 8 or higher installed
Run the AccountingLedgerApp.java file

Adding a Deposit

From the home screen, press D
Enter the date in format: yyyy-MM-dd (e.g., 2024-10-14)
Enter the time in format: HH:mm:ss (e.g., 14:30:00)
Enter a description for the transaction
Enter the vendor/source name
Enter the amount (positive number)

Making a Payment

From the home screen, press P
Follow the same prompts as adding a deposit
The amount will automatically be stored as negative

Viewing Reports

From the home screen, press L to enter the Ledger
Press R to access Reports
Select the desired report type
For custom search, you can leave any field blank to skip that filter

Data Storage
Transactions are stored in transactions.csv with the following format:
date|time|description|vendor|amount
Example:
2024-10-14|09:30:00|Monthly salary|ABC Corp|3500.00
2024-10-14|10:15:00|Grocery shopping|Walmart|-125.50
Interesting Code Feature
Bubble Sort Implementation for Date Sorting
One interesting aspect of this project is the implementation of a bubble sort algorithm to sort transactions by date in descending order (newest first). This was chosen because it uses only fundamental programming concepts covered in the curriculum.
java// Sort by date in descending order (newest first)
for (int i = 0; i < sortedTransactions.size() - 1; i++) {
for (int j = 0; j < sortedTransactions.size() - i - 1; j++) {
// Compare dates - if current is before next, swap them
if (sortedTransactions.get(j).getDate().isBefore(sortedTransactions.get(j + 1).getDate())) {
// Swap transactions
Transaction temp = sortedTransactions.get(j);
sortedTransactions.set(j, sortedTransactions.get(j + 1));
sortedTransactions.set(j + 1, temp);
}
}
}
This nested loop compares adjacent transactions and swaps them if they're in the wrong order. The outer loop runs n-1 times, and with each iteration, the largest element "bubbles" to its correct position. By using LocalDate's isBefore() method, we can efficiently compare dates and ensure transactions are always displayed chronologically.
The algorithm works by:

Comparing each pair of adjacent transactions
Swapping them if the first date comes before the second date
Repeating this process until no more swaps are needed
This ensures the most recent transactions appear at the top of the list

Technologies Used

Java 8+: Core programming language
java.time API: For date and time handling (LocalDate, LocalTime)
java.io: For file reading and writing (BufferedReader, BufferedWriter)
java.util: For collections (ArrayList, Scanner)

Project Structure
AccountingLedger/
├── src/
│   └── com/
│       └── pluralsight/
│           ├── AccountingLedgerApp.java  (Main application logic)
│           └── Transaction.java           (Transaction model class)
├── transactions.csv                       (Data storage file)
└── README.md                             (This file)
Author
Created as part of the Year Up Java Development Program - Capstone Project 1