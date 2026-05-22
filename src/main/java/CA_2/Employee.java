package CA_2;

/** Parent class for bank employees. */
public abstract class Employee {

    protected String name;
    protected String managerType;
    protected String departmentName;

    public Employee() {
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
