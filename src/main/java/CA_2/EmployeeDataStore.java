package CA_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stores all applicant records in memory using an ArrayList.
 */
public class EmployeeDataStore {

    private static final ArrayList<ApplicantRecord> records = new ArrayList<>();
    private static boolean sortedAlphabetically = false;

    private EmployeeDataStore() {
    }

    public static void clear() {
        records.clear();
        sortedAlphabetically = false;
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

    public static List<ApplicantRecord> getRecordsView() {
        return Collections.unmodifiableList(records);
    }
}
