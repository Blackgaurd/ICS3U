
/**
 * a series of stages where the user is
 * required to input something that fits
 * specified constraints to move on
 *
 * modified 20210819
 * date     20210819
 *
 * @filename DataValidationAndTestData.java
 * @author Bryan Deng
 * @version 1.0
 * @see unit 4 activity 1 content
 */

import java.util.Scanner;

public class DataValidationAndTestData {
    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        System.out.println("~~~~ STAGE 1 ~~~~");
        while (!stage1(keyedInput));
        congratulateUser(1, keyedInput);

        System.out.println("~~~~ STAGE 2 ~~~~");
        while (!stage2(keyedInput));
        congratulateUser(2, keyedInput);

        System.out.println("~~~~ STAGE 3 ~~~~");
        while (!stage3(keyedInput));
        congratulateUser(3, keyedInput);

        System.out.println("~~~~ STAGE 4 ~~~~");
        while (!stage4(keyedInput));
        congratulateUser(4, keyedInput);

        System.out.println("~~~~ STAGE 5 ~~~~");
        while (!stage5(keyedInput));
        congratulateUser(5, keyedInput);

        System.out.println("~~~~ STAGE 6 ~~~~");
        while (!stage6(keyedInput));
        congratulateUser(6, keyedInput);

        keyedInput.close();
    }

    private static boolean stage1(Scanner keyedInput) {
        // String greater than 6 characters
        promptInput("Please enter a string of more than 6 characters:");
        String input = keyedInput.nextLine();
        return input.length() > 6;
    }

    private static boolean stage2(Scanner keyedInput) {
        // String that contains at least
        // one lowercase 'a'
        promptInput("Please enter a string that contains at least one lowercase 'a':");
        String input = keyedInput.nextLine();
        return input.contains("a");
    }

    private static boolean stage3(Scanner keyedInput) {
        // String between 5 and 15 characters in length
        // and does not contain the lowercase character 'z'
        promptInput("Please enter a string between 5 and 15 characters (inclusive)\nthat does not contain a lowercase 'z':");
        String input = keyedInput.nextLine();

        boolean conditionLength = input.length() >= 5 && input.length() <= 15;
        boolean conditionChar = !input.contains("z");
        return conditionLength && conditionChar;
    }

    private static boolean stage4(Scanner keyedInput) {
        // integer in interval [5, 500]
        promptInput("Please enter an integer between 5 and 500 (inclusive):");
        int input = nextLineInt(keyedInput);
        return input >= 5 && input <= 500;
    }

    private static boolean stage5(Scanner keyedInput) {
        // negative integer
        promptInput("Please enter a negative integer:");
        int input = nextLineInt(keyedInput);
        return input < 0;
    }

    private static boolean stage6(Scanner keyedInput) {
        // positive, odd integer
        promptInput("Please enter a positive, odd integer");
        int input = nextLineInt(keyedInput);
        return input > 0 && (input & 1) == 1;
    }

    private static void promptInput(String prompt) {
        System.out.println(prompt);
        System.out.print(">>> ");
    }

    private static void congratulateUser(int stage, Scanner keyedInput) {
        System.out.printf("\nCongratulations on completing stage %d!\n", stage);
        promptInput("Please press enter to continue:");
        keyedInput.nextLine();
        System.out.println();
    }

    private static int nextLineInt(Scanner keyedInput) {
        while (true) {
            String inputString = keyedInput.nextLine().trim();
            try {
                return Integer.parseInt(inputString);
            } catch (Exception e) {
                System.out.print("Please enter an integer:\n>>> ");
            }
        }
    }
}
