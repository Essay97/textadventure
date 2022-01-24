package utils;

import java.util.Scanner;

/**
 * This class handles the user input. It is useful to "normalize" and unify the way that the prompt is presented to the
 * user
 */
public class Input {
    private static final Scanner s = new Scanner(System.in);

    /**
     * Prints to the screen the default prompt and waits for an input
     * @return the user input inserted after the prompt
     */
    public static String prompt() {
        System.out.print("-> ");
        return s.nextLine();
    }

    public static int intPrompt() {
        System.out.print("-> ");
        return s.nextInt();
    }
}
