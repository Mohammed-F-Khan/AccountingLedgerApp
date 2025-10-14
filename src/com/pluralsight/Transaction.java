package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

// this class is like a single financial transaction.
// it holds all the information about one deposti or payment
public class Transaction {
    // these variables store the transaction data.
    private LocalDate date; // the date transaction happended
    private LocalTime time; // the time the transaction happened.
    private String description; // this tells what the transaction was for.
    private String vendor; // who the transaction happened with.
    private double amount; // The dollar amount.
    // it should come out positive for deposits and negative for payments.

    // constructor - this method runs everytime a new transaction created
    // it takes all the information and puts them into to private labels.
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        // side note this. - means its refering to the current object's variables.
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // getters - returns the transactions date
    public LocalDate getDate() {
        return date;
    }
    // setters - now it lets me change the transaction date.
    public void setDate(LocalDate date) {
        this.date = date;
    }
    // returns the transaction time
    public LocalTime getTime() {
        return time;
    }
    // lets us change the transaction time
    public void setTime(LocalTime time) {
        this.time = time;
    }
    // returns the description
    public String getDescription() {
        return description;
    }
    // lets us change the description
    public void setDescription(String description) {
        this.description = description;
    }
    //returns the vendor name
    public String getVendor() {
        return vendor;
    }
    // lets us change the vendor name
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    // returns the transaction amount
    public double getAmount() {
        return amount;
    }
    // lets us change the transaction amount
    public void setAmount(double amount) {
        this.amount = amount;
    }
}