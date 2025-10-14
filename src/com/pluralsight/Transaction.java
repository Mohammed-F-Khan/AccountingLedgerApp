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
    private String vendor; // who the the transaction happened with.
    private double amount; // The dollar amount.
    // it should come out positive for deposits and negative for payments.
    

}