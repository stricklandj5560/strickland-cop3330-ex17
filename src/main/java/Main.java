import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class Main {

    final static double menRatio = 0.73;
    final static double womenRatio = 0.66;
    final static double c1 = 5.14;
    final static double c2 = 0.015;
    final static double legalBAC = 0.08;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            double maleOrFemale, ounces, weight, time, ratio, bac = 0;
            System.out.print("Enter 1 if you are a male or 2 if you are a female: ");
            maleOrFemale = getInput(scan);
            System.out.print("How many ounces of alcohol did you have? ");
            ounces = getInput(scan);
            System.out.print("What is your weight, in pounds? ");
            weight = getInput(scan);
            System.out.print("How many hours has it been since your last drink? ");
            time = getInput(scan);
            // do BAC calculation (BAC = (A * c1 / W * r) - c2 * H
            ratio = (maleOrFemale == 1) ? menRatio : womenRatio;
            bac = (ounces * c1 / weight * ratio) - (c2 * time);
            System.out.println("Your BAC is " + bac);
            System.out.println((bac <= legalBAC) ?
                    "It is legal for you to drive."
                    :
                    "It is not legal for you to drive.");
        }
    }

    /**
     * Gets a double value from the user and ensures that the
     * user enters a valid number
     * @param scan input scanner
     * @return user-entered value.
     */
    public static double getInput(Scanner scan) {
        double returnValue = 0;
        try {
            returnValue = Double.valueOf(scan.nextLine().trim());
        } catch (Exception e) {
            System.out.print("Please enter a valid number: ");
            return getInput(scan);
        }
        return returnValue;
    }
}
