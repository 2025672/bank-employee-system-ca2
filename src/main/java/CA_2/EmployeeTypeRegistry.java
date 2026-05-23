package CA_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores Employee subclass objects built from applicant records.
 */
public class EmployeeTypeRegistry {

    private static final ArrayList<Employee> employees = new ArrayList<>();

    private EmployeeTypeRegistry() {
    }

    public static void buildFromRecords(List<ApplicantRecord> records) {
        employees.clear();
        for (ApplicantRecord record : records) {
            employees.add(OrganizationFactory.createEmployeeFromRecord(record));
        }
    }

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static int getCount() {
        return employees.size();
    }

    public static void displayEmploymentSummary(int limit) {
        if (employees.isEmpty()) {
            return;
        }
        int show = Math.min(limit, employees.size());
        System.out.println("Employee types (first " + show + "):");
        for (int i = 0; i < show; i++) {
            System.out.println("  " + employees.get(i).getSummary());
        }
    }
}
