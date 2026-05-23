package CA_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Integrates all menu options and coordinates data, algorithms, and the binary tree.
 */
public class ApplicationController {

    private final Scanner scanner;

    public ApplicationController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printWelcome() {
        System.out.println("==================================================");
        System.out.println("  Bank Employee Management System");
        System.out.println("  CCT HDip - System Modelling & Build (CA_2)");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("Demo flow: 1 Read -> 2 Sort -> 3 Search -> 4 Add (optional)");
        System.out.println("           -> 5 Create tree -> 6 Display tree -> 7 Exit");
        System.out.println();
    }

    public boolean processMenuChoice(MenuOption option) {
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

    public void printSystemStatus() {
        if (EmployeeDataStore.isEmpty()) {
            System.out.println("[Status] No employee data loaded. Start with option 1.");
            return;
        }
        String sortedText = EmployeeDataStore.isSorted() ? "Yes" : "No (run option 2)";
        String treeText = TreeDataStore.hasTree() ? "Built" : "Not built (option 5)";
        System.out.println("[Status] Records: " + EmployeeDataStore.getCount()
                + " | Sorted: " + sortedText
                + " | Tree: " + treeText);
    }

    private void handleReadFile() {
        System.out.println();
        System.out.print("Please enter the filename to read (or press Enter for Applicants_Form.txt): ");
        String filename = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

        if (filename.isEmpty()) {
            filename = "Applicants_Form.txt";
        }

        if (!InputValidator.isValidFileName(filename)) {
            System.out.println("Invalid file name. Use only the file name (e.g. Applicants_Form.txt).");
            return;
        }

        System.out.println("Reading file: " + filename);

        try {
            List<ApplicantRecord> loaded = FileHandler.readApplicantsFile(filename);
            EmployeeDataStore.setRecords(loaded);
            EmployeeTypeRegistry.buildFromRecords(loaded);
            clearTree("New file loaded.");
            System.out.println("File read successfully.");
            System.out.println("Records loaded: " + EmployeeDataStore.getCount());
            EmployeeTypeRegistry.displayEmploymentSummary(5);
        } catch (IOException e) {
            clearAllData();
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    private void handleSortList() {
        if (!checkDataLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SORT selected.");

        try {
            ArrayList<ApplicantRecord> sorted = RecursiveMergeSort.sortByFullName(EmployeeDataStore.getRecords());
            EmployeeDataStore.setRecords(sorted);
            EmployeeDataStore.markSorted();

            int limit = Math.min(RecursiveMergeSort.getDisplayLimit(), sorted.size());
            System.out.println();
            System.out.println("First " + limit + " names (alphabetical order):");
            System.out.println("------------------------------------------");

            for (int i = 0; i < limit; i++) {
                System.out.println((i + 1) + ". " + sorted.get(i).getFullName());
            }

            System.out.println("------------------------------------------");
            System.out.println("Total records sorted: " + sorted.size());
            System.out.println("List is ready for binary search (option 3).");
        } catch (Exception e) {
            System.out.println("Sort failed: " + e.getMessage());
        }
    }

    private void handleSearchList() {
        if (!checkDataLoaded()) {
            return;
        }
        System.out.println();
        System.out.println("SEARCH selected.");

        String searchName = InputValidator.readNonEmptyLine(scanner, "Enter name to search: ");
        if (searchName.isEmpty()) {
            System.out.println("Search cancelled.");
            return;
        }

        if (!InputValidator.isValidPersonName(searchName)) {
            System.out.println("Invalid name format. Use letters and spaces only.");
            return;
        }

        try {
            ensureSortedForSearch();
            ArrayList<ApplicantRecord> records = EmployeeDataStore.getRecords();
            ApplicantRecord found = RecursiveBinarySearch.searchByName(records, searchName);

            System.out.println();
            if (found != null) {
                System.out.println("Employee found:");
                System.out.println("  Name: " + found.getFullName());
                System.out.println("  Manager Type: " + found.getJobTitle());
                System.out.println("  Department: " + found.getDepartment());
            } else {
                System.out.println("No employee found with name: " + searchName);
                System.out.println("Check spelling and use the full name (e.g. Jessica Lee).");
            }
        } catch (Exception e) {
            System.out.println("Search failed: " + e.getMessage());
        }
    }

    private void handleAddEmployee() {
        System.out.println();
        System.out.println("ADD RECORDS selected.");
        EmployeeInputHandler.addEmployee(scanner);
        EmployeeInputHandler.displayNewlyAddedRecords();
        clearTree("Employee list changed. Create the tree again (option 5).");
    }

    private void handleCreateBinaryTree() {
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

        try {
            EmployeeBinaryTree tree = new EmployeeBinaryTree();
            tree.buildFromRecords(EmployeeDataStore.getRecords());
            TreeDataStore.setTree(tree);

            System.out.println();
            System.out.println("Employee hierarchy binary tree created successfully.");
            System.out.println("Insertion method: level-order (breadth-first).");
            System.out.println("Total nodes inserted: " + tree.getNodeCount());
            System.out.println("Use option 6 to view traversal, height, and node count.");
        } catch (Exception e) {
            TreeDataStore.clear();
            System.out.println("Could not create tree: " + e.getMessage());
        }
    }

    private void handleDisplayBinaryTree() {
        System.out.println();
        System.out.println("Display Binary Tree selected.");

        if (!TreeDataStore.hasTree()) {
            System.out.println("Please create the binary tree first (option 5).");
            return;
        }

        try {
            EmployeeBinaryTree tree = TreeDataStore.getTree();
            System.out.println();
            tree.displayLevelOrderTraversal();
            System.out.println("Tree height: " + tree.getHeight());
            System.out.println("Total node count: " + tree.getNodeCount());
        } catch (Exception e) {
            System.out.println("Could not display tree: " + e.getMessage());
        }
    }

    /**
     * Binary search requires a sorted list. Sort automatically if the user skipped option 2.
     */
    private void ensureSortedForSearch() {
        if (!EmployeeDataStore.isSorted()) {
            System.out.println("Sorting list before search...");
            ArrayList<ApplicantRecord> sorted = RecursiveMergeSort.sortByFullName(EmployeeDataStore.getRecords());
            EmployeeDataStore.setRecords(sorted);
            EmployeeDataStore.markSorted();
        }
    }

    private void clearTree(String message) {
        if (TreeDataStore.hasTree()) {
            TreeDataStore.clear();
            System.out.println(message);
        }
    }

    private void clearAllData() {
        EmployeeDataStore.clear();
        EmployeeTypeRegistry.clear();
        TreeDataStore.clear();
    }

    private boolean checkDataLoaded() {
        if (EmployeeDataStore.isEmpty()) {
            System.out.println("Please read the file first (option 1).");
            return false;
        }
        return true;
    }
}
