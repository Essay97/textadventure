package utils;

import java.util.Scanner;

public class Input {

    private static Scanner s = new Scanner(System.in);

    public static String prompt() {
        System.out.print("-> ");
        String input = s.nextLine();
        return input;
    }
}
