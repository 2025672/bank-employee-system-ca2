package CA_2;

import java.util.ArrayList;

/**
 * Recursive binary search on a list sorted by full name (A–Z).
 * Used after merge sort — required by Algorithms & Constructs assignment.
 */
public class RecursiveBinarySearch {

    private RecursiveBinarySearch() {
    }

    /**
     * Searches for an employee by full name on a sorted list.
     *
     * @param sortedList list already sorted by name
     * @param targetName name to find (e.g. "John Smith")
     * @return matching record, or null if not found
     */
    public static ApplicantRecord searchByName(ArrayList<ApplicantRecord> sortedList, String targetName) {
        if (sortedList == null || sortedList.isEmpty() || targetName == null || targetName.trim().isEmpty()) {
            return null;
        }
        String target = targetName.trim();
        return binarySearch(sortedList, target, 0, sortedList.size() - 1);
    }

    /**
     * Recursive binary search: compare middle element, then search left or right half.
     */
    private static ApplicantRecord binarySearch(ArrayList<ApplicantRecord> list, String target, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        String midName = list.get(mid).getFullName();
        int comparison = midName.compareToIgnoreCase(target);

        if (comparison == 0) {
            return list.get(mid);
        } else if (comparison < 0) {
            return binarySearch(list, target, mid + 1, right);
        } else {
            return binarySearch(list, target, left, mid - 1);
        }
    }
}
