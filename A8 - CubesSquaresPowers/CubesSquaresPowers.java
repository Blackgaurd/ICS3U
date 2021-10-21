
/**
 * find square, cube, or power
 * of a base and/or exponent
 *
 * modified     20210811
 * date         20210811
 *
 * @filename    CubesSquaresPowers.java
 * @author      Bryan Deng
 * @version     1.0
 * @see         unit 3 activity 2 content
 */

import java.util.Scanner;

public class CubesSquaresPowers {
    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        int optionNum;
        double base;
        int exponent;

        while (true) {
            System.out.println("Please enter a number from one of the following options:");
            System.out.println("1 - calculate the square of an integer");
            System.out.println("2 - calculate the cube of an integer");
            System.out.println("3 - calculate the power of an integer to an inputed base");
            System.out.println("4 - exit the program");
            System.out.print(">>> ");

            optionNum = inputInt(keyedInput);

            if (optionNum == 1) {
                System.out.print("Please enter an integer to find its square:\n>>> ");
                base = inputDouble(keyedInput);

                double squareAns = base * base;
                System.out.printf("%.2f squared is %.2f\n", base, squareAns);
            } else if (optionNum == 2) {
                System.out.print("Please enter an integer to find its cube:\n>>> ");
                base = inputDouble(keyedInput);

                double cubeAns = base * base * base;
                System.out.printf("%.2f cubed is %.2f\n", base, cubeAns);
            } else if (optionNum == 3) {
                System.out.print("Please enter a base:\n>>> ");
                base = inputDouble(keyedInput);

                do {
                    System.out.print("Please enter a non-negative exponent:\n>>> ");
                    exponent = inputInt(keyedInput);
                } while (exponent < 0);

                // special undefined case
                if (base == 0 && exponent == 0) {
                    System.out.println("0 to the power of 0 is undefined.\n\n");
                    continue;
                }

                double answer = Math.pow(base, exponent);
                System.out.printf("%.2f to the power of %d is %.2f\n", base, exponent, answer);
            } else if (optionNum == 4) {
                System.out.println("Thanks for using the program, farewell!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        keyedInput.close();
    }

    private static int inputInt(Scanner keyedInput) {
        int input;
        while (true) {
            try {
                // parsing entire line to int
                // to avoid complications with
                // tokenization
                input = Integer.parseInt(keyedInput.nextLine().trim());
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                System.out.printf("Please enter an integer:\n>>> ");
            }
        }
    }

    private static double inputDouble(Scanner keyedInput) {
        double input;
        while (true) {
            try {
                // parsing entire line to double
                // to avoid complications with
                // tokenization
                input = Double.parseDouble(keyedInput.nextLine().trim());
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                System.out.printf("Please enter a number:\n>>> ");
            }
        }
    }
}
