package com.careerdevs.Intro.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc1Main {

    public static void main(String[] args) {

        /*

        //My Initial Version
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = Integer.parseInt(scanner.nextLine());

        System.out.print("Annual Interest Rate: ");
        float annualInterest = Float.parseFloat(scanner.nextLine());

        System.out.print("Period(Years): ");
        int loanDuration = Integer.parseInt(scanner.nextLine());

        float monthlyInterest = annualInterest/1200;
        int totalPayments = loanDuration * 12;

        float monthlyInterestCompounded = (float)Math.pow(monthlyInterest+1, totalPayments);


        float monthlyPayment = principal *  ( (monthlyInterest * monthlyInterestCompounded) / (monthlyInterestCompounded- 1) );

        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.print("Mortgage: " + monthlyPaymentFormatted);


         */

        //Mosh Version

        //Wants us to avoid using numeric literals in code. j
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

        //Known limitations => lack of input validation

    }
}
