package com.careerdevs.Intro.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

/*
*
* An extension of the original Mortgage Calculator
* with data validation/error handling.
*
* He uses an infinite loop to re-prompt the user
* to provide input that falls within a valid range.
*
* Known Limitations => Per Mosh, the program only has one method and that method has
*                      many lines. This hurts the maintainability of the program. Someone
*                      reading the code will have to look at all the statements to figure
*                      out what is going on. Going forward he is going to break the program
*                      down into smaller chunks that are both easier to read and easier to
*                      understand.
*
*/

public class MortgageCalc2Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            if (principal >= 1000 && principal <= 1_000_000)
                break;

            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();

            if (annualInterest >= 1 && annualInterest <=30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");

        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <=30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
