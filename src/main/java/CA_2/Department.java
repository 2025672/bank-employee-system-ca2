package CA_2;

/**
 * Parent class for bank departments (HR, Finance, Customer Service, etc.).
 */
public abstract class Department {

    protected String departmentName;

    public Department() {
        // Subtypes added in a later commit.
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
