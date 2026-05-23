package CA_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles adding a new employee with validation (name, manager type, department).
 */
public class EmployeeInputHandler {

    private static final ArrayList<ApplicantRecord> newlyAddedRecords = new ArrayList<>();

    private EmployeeInputHandler() {
    }

    public static void addEmployee(Scanner scanner) {
        System.out.println();
        System.out.print("Please input the employee name: ");
        String fullName = scanner.nextLine().trim();

        if (fullName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        String firstName;
        String lastName;
        int spaceIndex = fullName.indexOf(' ');

        if (spaceIndex == -1) {
            firstName = fullName;
            lastName = "";
        } else {
            firstName = fullName.substring(0, spaceIndex).trim();
            lastName = fullName.substring(spaceIndex + 1).trim();
            if (lastName.isEmpty()) {
                System.out.println("Please enter first and last name.");
                return;
            }
        }

        ManagerType.printOptions();
        System.out.print("Enter management choice: ");
        int managerChoice = readInt(scanner);
        ManagerType managerType = ManagerType.fromCode(managerChoice);

        if (managerType == null) {
            System.out.println("Invalid manager type. Record not added.");
            return;
        }

        DepartmentType.printOptions();
        System.out.print("Enter department choice: ");
        int departmentChoice = readInt(scanner);
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

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
