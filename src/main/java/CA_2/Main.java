package CA_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Bank Employee Management System — console entry point.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcome();
        runMenuLoop();
        System.out.println("Thank you. Goodbye.");
        SCANNER.close();
    }

    private static void printWelcome() {
        System.out.println("==================================================");
        System.out.println("  Bank Employee Management System");
        System.out.println("==================================================");
        System.out.println();
    }

    private static void runMenuLoop() {
        boolean running = true;

        while (running) {
            System.out.println();
            MenuOption.printAllOptions();
            System.out.print("Enter your choice: ");

            int choice = readIntInput();
            MenuOption selected = MenuOption.fromCode(choice);

            if (selected == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            running = handleMenuChoice(selected);
        }
    }

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

        System.out.println("Reading file: " + filename);

        try {
            List<ApplicantRecord> loaded = FileHandler.readApplicantsFile(filename);
            EmployeeDataStore.setRecords(loaded);
            System.out.println("File read successfully.");
            System.out.println("Records loaded: " + EmployeeDataStore.getCount());
        } catch (IOException e) {
            EmployeeDataStore.clear();
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    private static void handleSortList() {
        if (!checkDataLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SORT selected.");

        ArrayList<ApplicantRecord> sorted = RecursiveMergeSort.sortByFullName(EmployeeDataStore.getRecords());
        EmployeeDataStore.setRecords(sorted);

        int limit = Math.min(RecursiveMergeSort.getDisplayLimit(), sorted.size());
        System.out.println();
        System.out.println("First " + limit + " names (alphabetical order):");
        System.out.println("------------------------------------------");

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + sorted.get(i).getFullName());
        }

        System.out.println("------------------------------------------");
        System.out.println("Total records sorted: " + sorted.size());
    }

    private static void handleSearchList() {
        if (!checkDataLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SEARCH selected.");
        System.out.print("Enter name to search: ");
        String searchName = SCANNER.nextLine().trim();

        if (searchName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        // Binary search needs a sorted list (option 2 or sort here before search).
        ArrayList<ApplicantRecord> sorted = RecursiveMergeSort.sortByFullName(EmployeeDataStore.getRecords());
        EmployeeDataStore.setRecords(sorted);

        ApplicantRecord found = RecursiveBinarySearch.searchByName(sorted, searchName);

        System.out.println();
        if (found != null) {
            System.out.println("Employee found:");
            System.out.println("  Name: " + found.getFullName());
            System.out.println("  Manager Type: " + found.getJobTitle());
            System.out.println("  Department: " + found.getDepartment());
        } else {
            System.out.println("No employee found with name: " + searchName);
        }
    }

    private static void handleAddEmployee() {
        System.out.println();
        System.out.println("ADD RECORDS selected.");
        EmployeeInputHandler.addEmployee(SCANNER);
        EmployeeInputHandler.displayNewlyAddedRecords();
    }

    private static void handleCreateBinaryTree() {
        if (!checkDataLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("Create Binary Tree selected.");

        int recordCount = EmployeeDataStore.getCount();
        if (recordCount < EmployeeBinaryTree.MINIMUM_RECORDS) {
            System.out.println("At least " + EmployeeBinaryTree.MINIMUM_RECORDS
                    + " records are required. Currently loaded: " + recordCount);
            return;
        }

        EmployeeBinaryTree tree = new EmployeeBinaryTree();
        tree.buildFromRecords(EmployeeDataStore.getRecords());
        TreeDataStore.setTree(tree);

        System.out.println();
        System.out.println("Employee hierarchy binary tree created successfully.");
        System.out.println("Insertion method: level-order (breadth-first).");
        System.out.println("Total nodes inserted: " + tree.getNodeCount());
    }

    private static void handleDisplayBinaryTree() {
        System.out.println();
        System.out.println("Display Binary Tree selected.");

        if (!TreeDataStore.hasTree()) {
            System.out.println("Please create the binary tree first (option 5).");
        }
    }

    private static boolean checkDataLoaded() {
        if (EmployeeDataStore.isEmpty()) {
            System.out.println("Please read the file first (option 1).");
            return false;
        }
        return true;
    }

    private static int readIntInput() {
        while (!SCANNER.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            SCANNER.next();
        }
        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }
}
