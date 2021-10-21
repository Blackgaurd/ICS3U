
/**
 * a text-based program to guess
 * the fruit/vegetable that the
 * user is thinking of
 *
 * modified     20210811
 * date         20210811
 *
 * @filename    ChooseYourOwnAdventure.java
 * @author      Bryan Deng
 * @version     1.0
 * @see         unit 3 activity 1 content
 */

import java.util.Scanner;

public class ChooseYourOwnAdventure {

    public static void main(String[] args) {
        Scanner keyedInput = new Scanner(System.in);

        // format string for input prompts
        final String CHOICES_FMT = "Please enter:\n'%c' for %s\n'%c' for %s\n>>> ";

        char input;
        String guessedAnswer;

        // level 1
        System.out.println("Are you thinking of a fruit or vegetable?");
        System.out.printf(CHOICES_FMT, 'f', "fruit", 'v', "vegetable");
        input = handleInput('f', 'v', keyedInput);

        if (input == 'f') {
            // level 2.1
            System.out.println("\nIs your fruit orange or red?");
            System.out.printf(CHOICES_FMT, 'o', "orange", 'r', "red");
            input = handleInput('o', 'r', keyedInput);

            if (input == 'r') {
                // level 3.1
                System.out.println("\nDoes your fruit grow on trees or in the ground?");
                System.out.printf(CHOICES_FMT, 't', "trees", 'g', "ground");
                input = handleInput('t', 'g', keyedInput);

                if (input == 't') {
                    // level 4.1
                    guessedAnswer = "APPLE";
                } else {
                    // level 4.2
                    guessedAnswer = "STRAWBERRY";
                }
            } else {
                // level 3.2
                System.out.println("\nIs your fruit sour?");
                System.out.printf(CHOICES_FMT, 'y', "sour", 'n', "not sour");
                input = handleInput('y', 'n', keyedInput);

                if (input == 'y') {
                    // level 4.3
                    guessedAnswer = "ORANGE";
                } else {
                    // level 4.4
                    guessedAnswer = "MANGO";
                }
            }

            System.out.printf("\nIs your fruit a %s?\n", guessedAnswer);
        } else {
            // level 2.2
            System.out.println("\nDoes your vegetable have leaves?");
            System.out.printf(CHOICES_FMT, 'y', "leaves", 'n', "no leaves");
            input = handleInput('y', 'n', keyedInput);

            if (input == 'y') {
                // level 3.3
                System.out.println("\nIs your vegetable round?");
                System.out.printf(CHOICES_FMT, 'y', "round", 'n', "not round");
                input = handleInput('y', 'n', keyedInput);

                if (input == 'y') {
                    // level 4.5
                    guessedAnswer = "CABBAGE";
                } else {
                    // level 4.6
                    guessedAnswer = "SPINACH";
                }
            } else {
                // level 3.4
                System.out.println("\nIs your vegetable brown or yellow?");
                System.out.printf(CHOICES_FMT, 'y', "yellow", 'b', "brown");
                input = handleInput('y', 'b', keyedInput);

                if (input == 'y') {
                    // level 4.7
                    guessedAnswer = "YELLOW BELL PEPPER";
                } else {
                    // level 4.8
                    guessedAnswer = "POTATO";
                }
            }

            System.out.printf("\nIs your vegetable a %s?\n", guessedAnswer);
        }

        keyedInput.close();
    }

    private static char handleInput(char choice1, char choice2, Scanner keyedInput) {
        final String INVALID_INPUT_FMT = "\nInvalid input, please enter a single character (%c/%c):\n>>> ";

        String inputStr;
        char inputChar;

        while (true) {
            inputStr = keyedInput.nextLine().trim();

            if (inputStr.length() != 1) {
                System.out.printf(INVALID_INPUT_FMT, choice1, choice2);
                continue;
            }

            inputChar = Character.toLowerCase(inputStr.charAt(0));
            if (inputChar != choice1 && inputChar != choice2) {
                System.out.printf(INVALID_INPUT_FMT, choice1, choice2);
                continue;
            }

            return inputChar;
        }
    }
}