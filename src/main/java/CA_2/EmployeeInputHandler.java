package CA_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles adding a new employee with validation (name, manager type, department).
 */
public class EmployeeInputHandler {

    private static final int MANAGER_MIN = 1;
    private static final int MANAGER_MAX = 3;
    private static final int DEPARTMENT_MIN = 1;
    private static final int DEPARTMENT_MAX = 3;

    private static final ArrayList<ApplicantRecord> newlyAddedRecords = new ArrayList<>();

    private EmployeeInputHandler() {
    }

    public static void addEmployee(Scanner scanner) {
        System.out.println();
        String fullName = InputValidator.readNonEmptyLine(scanner, "Please input the employee name: ");

        if (fullName.isEmpty()) {
            System.out.println("Add employee cancelled.");
            return;
        }

        if (!InputValidator.isValidPersonName(fullName)) {
            System.out.println("Invalid name. Use letters, spaces, apostrophes, or hyphens only.");
            return;
        }

        String firstName;
        String lastName;
        int spaceIndex = fullName.indexOf(' ');

        if (spaceIndex == -1) {
            System.out.println("Please enter first and last name (e.g. John Smith).");
            return;
        }

        firstName = fullName.substring(0, spaceIndex).trim();
        lastName = fullName.substring(spaceIndex + 1).trim();

        if (lastName.isEmpty() || !InputValidator.isValidPersonName(firstName)
                || !InputValidator.isValidPersonName(lastName)) {
            System.out.println("Please enter a valid first and last name.");
            return;
        }

        ManagerType.printOptions();
        int managerChoice = InputValidator.readIntInRange(scanner, MANAGER_MIN, MANAGER_MAX,
                "Enter management choice: ");
        ManagerType managerType = ManagerType.fromCode(managerChoice);

        if (managerType == null) {
            System.out.println("Invalid manager type. Record not added.");
            return;
        }

        DepartmentType.printOptions();
        int departmentChoice = InputValidator.readIntInRange(scanner, DEPARTMENT_MIN, DEPARTMENT_MAX,
                "Enter department choice: ");
        DepartmentType department = DepartmentType.fromCode(departmentChoice);

        if (department == null) {
            System.out.println("Invalid department. Record not added.");
            return;
        }

        ApplicantRecord record = new ApplicantRecord(
                firstName,
                lastName,
                "",
                "n/a",
                0.0,
                department.getLabel(),
                "",
                managerType.getLabel(),
                "Bank"
        );

        EmployeeDataStore.addRecord(record);
        newlyAddedRecords.add(record);

        Manager manager = OrganizationFactory.createManager(managerType);
        Department dept = OrganizationFactory.createDepartment(department);
        Employee employee = new FullTimeEmployee(
                record.getFullName(), managerType.getLabel(), department.getLabel());
        EmployeeTypeRegistry.addEmployee(employee);

        System.out.println();
        System.out.println("\"" + record.getFullName() + "\" has been added as \""
                + managerType.getLabel() + "\" to \"" + department.getLabel() + "\" successfully!");
        System.out.println("Role: " + manager.describeRole());
        System.out.println("Department code: " + dept.getDepartmentCode()
                + " | Employment: " + employee.getEmploymentType());
    }

    public static void displayNewlyAddedRecords() {
        System.out.println();
        if (newlyAddedRecords.isEmpty()) {
            System.out.println("No new records have been added in this session.");
            return;
        }

        System.out.println("Newly added records:");
        System.out.println("------------------------------------------");
        for (int i = 0; i < newlyAddedRecords.size(); i++) {
            ApplicantRecord record = newlyAddedRecords.get(i);
            System.out.println((i + 1) + ". " + record.getFullName()
                    + " | " + record.getJobTitle()
                    + " | " + record.getDepartment());
        }
        System.out.println("------------------------------------------");
        System.out.println("Total new records: " + newlyAddedRecords.size());
    }
}
