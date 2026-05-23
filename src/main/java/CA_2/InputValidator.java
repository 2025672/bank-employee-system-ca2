package CA_2;

import java.util.Scanner;

/**
 * Central validation and safe console input handling.
 */
public class InputValidator {

    private InputValidator() {
    }

    /**
     * Reads a menu option between 1 and 7.
     */
    public static int readMenuChoice(Scanner scanner) {
        return readIntInRange(scanner, MenuOption.getMinCode(), MenuOption.getMaxCode(),
                null);
    }

    /**
     * Reads an integer within a valid range. Re-prompts until input is valid.
     */
    public static int readIntInRange(Scanner scanner, int min, int max, String prompt) {
        while (true) {
            if (prompt != null && !prompt.isEmpty()) {
                System.out.print(prompt);
            }

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a whole number between "
                        + min + " and " + max + ".");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                continue;
            }

            int value = scanner.nextInt();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("Choice " + value + " is out of range. Enter "
                    + min + " to " + max + ".");
        }
    }

    /**
     * Reads a non-empty line of text.
     */
    public static String readNonEmptyLine(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                return "";
            }
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    /**
     * Validates a file name (no paths or parent-folder tricks).
     */
    public static boolean isValidFileName(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return false;
        }
        String name = filename.trim();
        return !name.contains("..") && !name.contains("/") && !name.contains("\\");
    }

    /**
     * Validates a person name (letters, spaces, apostrophes, hyphens).
     */
    public static boolean isValidPersonName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        String trimmed = name.trim();
        if (trimmed.length() < 2) {
            return false;
        }
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '\'' && c != '-') {
                return false;
            }
        }
        return true;
    }
}
