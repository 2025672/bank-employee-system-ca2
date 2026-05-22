package CA_2;

/**
 * Parent class for all employee types in the bank organisation.
 * Subtypes (e.g. FullTime, PartTime, Contract) added in a later commit for extra marks.
 */
public abstract class Employee {

    protected String name;
    protected String managerType;
    protected String departmentName;

    public Employee() {
        // Fields and constructors expanded when data model is implemented.
    }

    public String getName() {
        return name;
    }

    public String getManagerType() {
        return managerType;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
