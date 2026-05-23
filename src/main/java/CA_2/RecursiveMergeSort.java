package CA_2;

import java.util.ArrayList;

/**
 * Recursive merge sort for applicant names (alphabetical order).
 * Required by Algorithms & Constructs assignment.
 */
public class RecursiveMergeSort {

    private static final int DISPLAY_LIMIT = 20;

    private RecursiveMergeSort() {
    }

    /**
     * Returns a new list sorted by full name (A–Z).
     */
    public static ArrayList<ApplicantRecord> sortByFullName(ArrayList<ApplicantRecord> records) {
        ArrayList<ApplicantRecord> copy = new ArrayList<>(records);
        if (copy.size() <= 1) {
            return copy;
        }
        mergeSort(copy, 0, copy.size() - 1);
        return copy;
    }

    /**
     * Recursive merge sort: divide the list in half, sort each half, then merge.
     */
    private static void mergeSort(ArrayList<ApplicantRecord> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    /**
     * Merges two sorted halves into one sorted range.
     */
    private static void merge(ArrayList<ApplicantRecord> list, int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        ArrayList<ApplicantRecord> leftPart = new ArrayList<>(sizeLeft);
        ArrayList<ApplicantRecord> rightPart = new ArrayList<>(sizeRight);

        for (int i = 0; i < sizeLeft; i++) {
            leftPart.add(list.get(left + i));
        }
        for (int j = 0; j < sizeRight; j++) {
            rightPart.add(list.get(mid + 1 + j));
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (compareByName(leftPart.get(i), rightPart.get(j)) <= 0) {
                list.set(k, leftPart.get(i));
                i++;
            } else {
                list.set(k, rightPart.get(j));
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            list.set(k, leftPart.get(i));
            i++;
            k++;
        }

        while (j < sizeRight) {
            list.set(k, rightPart.get(j));
            j++;
            k++;
        }
    }

    private static int compareByName(ApplicantRecord a, ApplicantRecord b) {
        return a.getFullName().compareToIgnoreCase(b.getFullName());
    }

    public static int getDisplayLimit() {
        return DISPLAY_LIMIT;
    }
}
