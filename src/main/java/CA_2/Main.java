package CA_2;

import java.util.Scanner;

/**
 * Bank Employee Management System
 * CCT College Dublin - HDip in Computing
 * Integrated CA: Algorithms and Constructs + Software Development Fundamentals
 * Assignment: System Modelling and Build
 *
 * Console menu driven by MenuOption enum. Feature logic added in later commits.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static boolean fileLoaded = false;

    public static void main(String[] args) {
        printWelcome();
        runMenuLoop();
        System.out.println("Thank you. Goodbye.");
        SCANNER.close();
    }

    private static void printWelcome() {
        System.out.println("==================================================");
        System.out.println("  Bank Employee Management System");
        System.out.println("  Organisation: Bank | Package: CA_2");
        System.out.println("==================================================");
        System.out.println();
    }

    /**
     * Main menu loop: keeps running until the user chooses Exit.
     */
    private static void runMenuLoop() {
        boolean running = true;

        while (running) {
            System.out.println();
            MenuOption.printAllOptions();
            System.out.print("Enter your choice: ");

            int choice = readIntInput();
            MenuOption selected = MenuOption.fromCode(choice);

            if (selected == null) {
                System.out.println("Invalid option. Please enter a number from the menu.");
                continue;
            }

            running = handleMenuChoice(selected);
        }
    }

    /**
     * Handles the selected menu option. Returns false when the program should exit.
     */
    private static boolean handleMenuChoice(MenuOption option) {
        switch (option) {
            case READ_FILE:
                handleReadFile();
                break;
            case SORT_LIST:
                handleSortList();
                break;
            case SEARCH_LIST:
                handleSearchList();
                break;
            case ADD_EMPLOYEE:
                handleAddEmployee();
                break;
            case CREATE_BINARY_TREE:
                handleCreateBinaryTree();
                break;
            case DISPLAY_BINARY_TREE:
                handleDisplayBinaryTree();
                break;
            case EXIT:
                return false;
            default:
                System.out.println("Unknown option.");
        }
        return true;
    }

    private static void handleReadFile() {
        System.out.println();
        System.out.print("Please enter the filename to read (or press Enter for Applicants_Form.txt): ");
        String filename = SCANNER.nextLine().trim();
        if (filename.isEmpty()) {
            filename = "Applicants_Form.txt";
        }
        // File reading will be implemented in the next commit.
        fileLoaded = true;
        System.out.println("Reading file: " + filename);
        System.out.println("File read successfully (parser coming in next commit).");
    }

    private static void handleSortList() {
        if (!checkFileLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SORT selected.");
        System.out.println("Recursive merge sort will be implemented in a later commit.");
    }

    private static void handleSearchList() {
        if (!checkFileLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SEARCH selected.");
        System.out.println("Recursive binary search will be implemented in a later commit.");
    }

    private static void handleAddEmployee() {
        System.out.println();
        System.out.println("ADD RECORDS selected.");
        System.out.println("Add employee with validation will be implemented in a later commit.");
    }

    private static void handleCreateBinaryTree() {
        if (!checkFileLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("Create Binary Tree selected.");
        System.out.println("Binary tree insertion will be implemented in a later commit.");
    }

    private static void handleDisplayBinaryTree() {
        System.out.println();
        System.out.println("Display Binary Tree selected.");
        System.out.println("Level-order traversal will be implemented in a later commit.");
    }

    /**
     * Some actions need the file loaded first.
     */
    private static boolean checkFileLoaded() {
        if (!fileLoaded) {
            System.out.println("Please read the file first (option 1).");
            return false;
        }
        return true;
    }

    /**
     * Reads an integer from the user. Re-prompts if input is not a number.
     */
    private static int readIntInput() {
        while (!SCANNER.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            SCANNER.next();
        }
        int value = SCANNER.nextInt();
        SCANNER.nextLine(); // consume newline after the number
        return value;
    }
}
