package CA_2;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory store for applicant records and the active binary tree.
 */
public class EmployeeDataStore {

    private static final ArrayList<ApplicantRecord> records = new ArrayList<>();
    private static boolean sortedAlphabetically = false;
    private static EmployeeBinaryTree tree;

    private EmployeeDataStore() {
    }

    public static void clear() {
        records.clear();
        sortedAlphabetically = false;
        tree = null;
    }

    public static void setRecords(List<ApplicantRecord> loadedRecords) {
        records.clear();
        records.addAll(loadedRecords);
        sortedAlphabetically = false;
    }

    public static ArrayList<ApplicantRecord> getRecords() {
        return records;
    }

    public static int getCount() {
        return records.size();
    }

    public static boolean isEmpty() {
        return records.isEmpty();
    }

    public static void addRecord(ApplicantRecord record) {
        records.add(record);
        sortedAlphabetically = false;
    }

    public static void markSorted() {
        sortedAlphabetically = true;
    }

    public static boolean isSorted() {
        return sortedAlphabetically;
    }

    public static void setTree(EmployeeBinaryTree newTree) {
        tree = newTree;
    }

    public static EmployeeBinaryTree getTree() {
        return tree;
    }

    public static boolean hasTree() {
        return tree != null && !tree.isEmpty();
    }

    public static void clearTree() {
        tree = null;
    }
}
