package CA_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stores all applicant records in memory using an ArrayList.
 */
public class EmployeeDataStore {

    private static final ArrayList<ApplicantRecord> records = new ArrayList<>();

    private EmployeeDataStore() {
    }

    public static void clear() {
        records.clear();
    }

    public static void setRecords(List<ApplicantRecord> loadedRecords) {
        records.clear();
        records.addAll(loadedRecords);
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
    }

    /** Returns an unmodifiable view for safe read-only access. */
    public static List<ApplicantRecord> getRecordsView() {
        return Collections.unmodifiableList(records);
    }
}
