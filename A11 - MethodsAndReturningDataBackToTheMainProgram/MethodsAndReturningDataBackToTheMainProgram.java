
/**
 * pick from 10 math functions
 * and print its output for
 * given input(s)
 *
 * modified 20210817
 * date     20210817
 *
 * @filename MethodsAndReturningDataBackToTheMainProgram.java
 * @author Bryan Deng
 * @version 1.0
 * @see unit 3 activity 5 content
 */
import java.util.Scanner;

public class MethodsAndReturningDataBackToTheMainProgram {

    private static final String[] CHOICES = {
        "A - maximum of two numbers",
        "B - minimum of two numbers",
        "C - square of a number",
        "D - cube of a number",
        "E - one number to the power of another",
        "F - square root of a number",
        "G - absolute value of a number",
        "H - round a number to the closest integer",
        "I - convert a degree value to radians",
        "J - convert a radian value to degrees",
        "K - exit the program"
    };

    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        boolean running = true;
        while (running) {
            promptChoices();
            char choice = inputChar('A', 'K', keyedInput);

            // loosely named variables
            // to be used globally within
            // switch statement
            double num1, num2;
            int int1, int2;

            switch (choice) {
                case 'A':
                    num1 = inputDouble("Please enter the first number:", -1000.0, 1000.0, keyedInput);
                    num2 = inputDouble("Please enter the second number:", -1000.0, 1000.0, keyedInput);

                    double maximum = max(num1, num2);
                    System.out.printf("The maximum of %.2f and %.2f is:\n%.2f\n", num1, num2, maximum);
                    break;

                case 'B':
                    num1 = inputDouble("Please enter the first number:", -1000.0, 1000.0, keyedInput);
                    num2 = inputDouble("Please enter the second number:", -1000.0, 1000.0, keyedInput);

                    double minimum = min(num1, num2);
                    System.out.printf("The minimum of %.2f and %.2f is:\n%.2f\n", num1, num2, minimum);
                    break;

                case 'C':
                    num1 = inputDouble("Please enter the base:", -1000.0, 1000.0, keyedInput);

                    double square = square(num1);
                    System.out.printf("The square of %.2f is:\n%.2f\n", num1, square);
                    break;

                case 'D':
                    num1 = inputDouble("Please enter the base:", -1000.0, 1000.0, keyedInput);

                    double cube = cube(num1);
                    System.out.printf("The cube of %.2f is:\n%.2f\n", num1, cube);
                    break;

                case 'E':
                    int1 = inputInt("Please enter the base:", -1000, 1000, keyedInput);
                    int2 = inputInt("Please enter the exponent:", 0, 10, keyedInput);

                    int expAnswer = power(int1, int2);
                    if (expAnswer == -1) {
                        System.out.println("Integer overflow: the result is too big!");
                        break;
                    }
                    System.out.printf("%d to the power of %d is:\n%d\n", int1, int2, expAnswer);
                    break;

                case 'F':
                    num1 = inputDouble("Please enter a number:", -1000.0, 1000.0, keyedInput);

                    double sqrt = sqrt(num1);
                    if (sqrt == -1) {
                        System.out.printf("The square root of %.2f is:\nUNDEFINED (negative input)\n", num1);
                    } else {
                        System.out.printf("The square root of %.2f is:\n%.2f\n", num1, sqrt);
                    }
                    break;

                case 'G':
                    num1 = inputDouble("Please enter a number:", -1000.0, 1000.0, keyedInput);

                    double abs = abs(num1);
                    System.out.printf("The absolute value of %.2f is:\n%.2f\n", num1, abs);
                    break;

                case 'H':
                    num1 = inputDouble("Please enter a number:", -1000.0, 1000.0, keyedInput);

                    int roundAnswer = round(num1);
                    System.out.printf("%.2f rounded to the nearest integer is:\n%d\n", num1, roundAnswer);
                    break;

                case 'I':
                    num1 = inputDouble("Please enter a value in degrees:", -720.0, 720.0, keyedInput);

                    double radians = degToRad(num1);
                    System.out.printf("%.2f degrees to radians is:\n%.2f\n", num1, radians);
                    break;

                case 'J':
                    num1 = inputDouble("Please enter a value in radians:", -15, 15, keyedInput);

                    double degrees = radToDeg(num1);
                    System.out.printf("%.2f radians to degrees is:\n%.2f\n", num1, degrees);
                    break;

                case 'K':
                    System.out.println("Exiting the program, have a good day!");
                    running = false;
                    break;
            }

            if (running) {
                System.out.printf("\n\nEnter any value to continue the program:\n>>> ");
                keyedInput.nextLine();
            }
        }

        keyedInput.close();
    }

    private static double max(double num1, double num2) {
        return Math.max(num1, num2);
    }

    private static double min(double num1, double num2) {
        return Math.min(num1, num2);
    }

    private static double square(double base) {
        return Math.pow(base, 2);
    }

    private static double cube(double base) {
        return Math.pow(base, 3);
    }

    private static int power(int base, int exponent) {
        // custom power function instead
        // of Math.pow() in order to
        // handle int overflow
        int answer = 1;
        for (int i = 0; i < exponent; i++) {
            try {
                answer = Math.multiplyExact(answer, base);
            } catch (Exception e) {
                return -1;
            }
        }
        return answer;
    }

    private static double sqrt(double num) {
        // return -1 instead of
        // default NaN in negative number
        // for easier exception handling
        // in main method
        return num < 0.0 ? -1 : Math.sqrt(num);
    }

    private static double abs(double num) {
        return Math.abs(num);
    }

    private static int round(double num) {
        return (int) Math.round(num);
    }

    private static double degToRad(double degrees) {
        return Math.toRadians(degrees);
    }

    private static double radToDeg(double radians) {
        return Math.toDegrees(radians);
    }

    private static void promptChoices() {
        System.out.println("Please enter a letter (A - K) to pick one of the following options:");
        for (String choice : CHOICES) {
            System.out.println(choice);
        }
        System.out.print(">>> ");
    }

    private static char inputChar(char boundLower, char boundUpper, Scanner keyedInput) {
        String inputString;
        char input;

        while (true) {
            inputString = keyedInput.nextLine();
            if (inputString.length() != 1) {
                System.out.printf("Please enter a single character from (%c - %c)\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }

            input = inputString.charAt(0);
            if (input < boundLower || input > boundUpper) {
                System.out.println("Watch out for upper/lower case!");
                System.out.printf("Please enter a single character from (%c - %c)\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }
            return input;
        }
    }

    private static int inputInt(String prompt, int boundLower, int boundUpper, Scanner keyedInput) {
        String inputString;
        int input;

        System.out.println(prompt);
        System.out.print(">>> ");

        while (true) {
            inputString = keyedInput.nextLine();
            try {
                input = Integer.parseInt(inputString);
            } catch (Exception e) {
                System.out.printf("Please enter an integer within [%d, %d]\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }

            if (input < boundLower || input > boundUpper) {
                System.out.printf("Please enter an integer within [%d, %d]\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }
            return input;
        }
    }

    private static double inputDouble(String prompt, double boundLower, double boundUpper, Scanner keyedInput) {
        String inputString;
        double input;

        System.out.println(prompt);
        System.out.print(">>> ");

        while (true) {
            inputString = keyedInput.nextLine();
            try {
                input = Double.parseDouble(inputString);
            } catch (Exception e) {
                System.out.printf("Please enter a number within [%.2f, %.2f]\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }

            if (input < boundLower || input > boundUpper) {
                System.out.printf("Please enter a number within [%.2f, %.2f]\n", boundLower, boundUpper);
                System.out.print(">>> ");
                continue;
            }
            return input;
        }
    }
}
