# 📊 Accounting Ledger Application

## What This Project Is About

I built this command-line application to help track financial transactions - basically deposits and payments. Everything gets saved to a CSV file so your data sticks around even after you close the app. This was my first capstone project for the Year Up Java Development program, and I learned a ton building it!

The main idea is pretty simple: you can add money coming in (deposits), record money going out (payments), and then view everything in different ways through reports. It's like a mini accounting system that runs right in your terminal.

---

## What It Can Do

### Main Menu (Home Screen)
When you start the app, you get four options:
- **Add Deposit** - Record money coming in (like paychecks or payments from clients)
- **Make Payment** - Record money going out (automatically makes it negative)
- **Ledger** - View all your transactions in different ways
- **Exit** - Close the app

### The Ledger
Once you're in the ledger, you can:
- See all your entries sorted by date (newest first)
- Filter to see only deposits (the positive ones)
- Filter to see only payments (the negative ones)
- Jump into the reports section
- Go back to the home screen

### Reports Section
This is where it gets more useful. You can:
- **Month To Date** - See everything from the start of this month until today
- **Previous Month** - View the entire last month's transactions
- **Year To Date** - Check out everything from January 1st until now
- **Previous Year** - Look at last year's full transaction history
- **Search by Vendor** - Find all transactions with a specific company or person
- **Custom Search** - This is the challenge feature I added! You can search by date range, description, vendor, or amount. Leave anything blank to skip that filter.

---

## Screenshots

### Home Screen
<img width="605" height="478" alt="Screenshot 2025-10-16 145946" src="https://github.com/user-attachments/assets/db9a91bd-6b24-4e3e-9965-a779c3849980" />

*The welcome screen and main menu*

### Adding a Deposit
<img width="431" height="482" alt="Screenshot 2025-10-16 150106" src="https://github.com/user-attachments/assets/896e9ecd-ceb8-49dd-aaf7-46cc2ec5d5fd" />

*Adding a $1000 paycheck from CVS*

### Ledger Menu
<img width="516" height="290" alt="Screenshot 2025-10-16 150149" src="https://github.com/user-attachments/assets/9a9e358a-dc6d-4f77-a5cd-90ec0989008b" />

*The ledger screen with all viewing options*

### All Entries View
<img width="841" height="833" alt="Screenshot 2025-10-16 150228" src="https://github.com/user-attachments/assets/54df95b3-eade-44c8-9d31-3bffcffad229" />

*Complete transaction history sorted by date*

### Deposits Only
<img width="831" height="667" alt="Screenshot 2025-10-16 150253" src="https://github.com/user-attachments/assets/1fd06b63-5281-4014-b9ae-f60ea922dec6" />

*Filtering to show only money coming in*

### Payments Only
<img width="852" height="636" alt="Screenshot 2025-10-16 150312" src="https://github.com/user-attachments/assets/6a2c42ec-e458-44ee-9a4c-6ddbdb759174" />

*Filtering to show only money going out*

### Reports Menu
<img width="508" height="366" alt="Screenshot 2025-10-16 150330" src="https://github.com/user-attachments/assets/13782222-15fc-4b29-96b7-22a0de14fe4f" />

*All the different report options available*

### Month To Date Report
<img width="842" height="593" alt="Screenshot 2025-10-16 150401" src="https://github.com/user-attachments/assets/fe34a999-9cb9-4575-a987-08dab2a06959" />

*Transactions from October 1st to today (October 16th)*

### Search by Vendor
<img width="821" height="611" alt="Screenshot 2025-10-16 150430" src="https://github.com/user-attachments/assets/aec8f87c-e114-4f9b-a9ac-f6cebebffc36" />

*Searching for "Walamrt" - shows no results found message*

### Custom Search
<img width="427" height="220" alt="Screenshot 2025-10-16 150510" src="https://github.com/user-attachments/assets/028012d2-ae88-489d-8ba9-618e0243db76" />

*The custom search prompts - can filter by multiple criteria*

### Exit Message
<img width="491" height="123" alt="Screenshot 2025-10-16 150531" src="https://github.com/user-attachments/assets/bb7012ba-a05a-4356-b99a-5c959f584934" />

*Goodbye message when exiting the application*

---

## How My Project Is Set Up
```
AccountingLedgerApp/
│
├── src/
│   └── com/
│       └── pluralsight/
│           ├── AccountingLedgerApp.java    # The main file with all the menus
│           └── Transaction.java             # The class that holds transaction info
│
├── transactions.csv                         # Where all the data gets saved
├── .gitignore                              
└── README.md                               # You're reading it!
```

---

## What I Used to Build This

- **Java** - The main programming language
- **LocalDate & LocalTime** - Java's built-in classes for handling dates and times
- **ArrayList** - To store and manage all the transactions
- **File I/O** - Reading from and writing to the CSV file
- **Scanner** - Getting input from the user

---

## How to Run It

If you want to try this out yourself:

1. Make sure you have Java installed (JDK 8 or newer)
2. Clone this repo or download the files
3. Open it in IntelliJ IDEA (or any Java IDE)
4. Find `AccountingLedgerApp.java` in the src folder
5. Right-click and hit Run
6. Follow the menu prompts!

The CSV file will be created automatically the first time you add a transaction.

---

## About the CSV File

All transactions get saved to `transactions.csv` in this format:
```
date|time|description|vendor|amount
```

Here's what some actual entries look like:
```csv
2025-10-16|14:30|Account Check|Walmart|1.00
2025-10-16|15:00|First Paycheck|CVS|1000.00
2024-10-10|15:45|Office supplies|Staples|-75.25
```

**Quick notes:**
- Deposits are positive numbers
- Payments are negative numbers
- The `|` symbol separates each piece of info
- Dates look like: `2025-10-16` (year-month-day)
- Times look like: `15:00:00` (military time)

---

## The Most Interesting Part of My Code

The coolest thing I figured out was how to filter transactions by date ranges. I use this same logic in all the report methods:
```java
// Check if transaction date falls within our date range
if ((transaction.getDate().isEqual(startOfPreviousMonth) || transaction.getDate().isAfter(startOfPreviousMonth)) &&
    (transaction.getDate().isEqual(endOfPreviousMonth) || transaction.getDate().isBefore(endOfPreviousMonth))) {
    // If it does, print it out
    System.out.printf("%-12s %-10s %-25s %-20s %10.2f\n",
            transaction.getDate(),
            transaction.getTime(),
            transaction.getDescription(),
            transaction.getVendor(),
            transaction.getAmount());
}
```

**Why I think this is interesting:**

At first, I thought I'd just check if a date was after the start and before the end. But then I realized - what about transactions that happen exactly on the first or last day of the month? They'd get missed!

So I had to use `isEqual()` along with `isAfter()` and `isBefore()`. The logic basically says:
- Is the transaction on or after the start date? **AND**
- Is the transaction on or before the end date?

Both conditions have to be true for it to show up in the report.

We actually learned a method called `isWithinRange()` in the workbook that does this exact thing, but I decided to write it out directly in each method so I could see exactly what was happening. It made debugging way easier!

---

## What I Learned

This project really helped me understand:
- How to design classes and use objects (the Transaction class)
- Working with dates and times in Java
- Reading and writing files (the CSV stuff was tricky at first!)
- Using ArrayLists to store and organize data
- Sorting data (I used bubble sort to show newest transactions first)
- Building menus that are easy to use
- Handling errors when users type something wrong

The date filtering was probably the hardest part, but once I got it working it felt really good because I could reuse the same pattern everywhere.

---

## Extra Features I Added

I completed the challenge requirements:
- ✅ **Custom Search** - You can filter by start date, end date, description, vendor, and amount all at once
- ✅ **Nice-Looking Interface** - Used those fancy box-drawing characters to make it look professional
- ✅ **Lots of Comments** - I tried to explain not just what the code does, but why I did it that way

---

## What I'd Do Differently Next Time

Looking back, there are a few things I might change:
- Create a helper method for the date range filtering instead of copying the same code
- Add more input validation (like making sure amounts are actually numbers)
- Maybe add a way to edit or delete transactions
- Use better variable names in some spots

But overall I'm pretty happy with how it turned out!

---

## Thanks To

- My instructors at Year Up United
- The Pluralsight platform and course materials
- Stack Overflow for helping me debug that one really annoying file reading issue
- Coffee, for obvious reasons ☕

---

## About Me

I'm a student in the Year Up United Java Development program, learning to code and build real applications. This is my first capstone project!

GitHub: [@Mohammed-F-Khan](https://github.com/Mohammed-F-Khan/AccountingLedgerApp/new/main?filename=README.md)

---

**Hope you like my Accounting Ledger app! Feel free to try it out or use it as inspiration for your own projects.** 🚀
