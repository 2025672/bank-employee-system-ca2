package CA_2;

/** Parent class for bank employees. */
public abstract class Employee {

    protected String name;
    protected String managerType;
    protected String departmentName;

    protected Employee(String name, String managerType, String departmentName) {
        this.name = name;
        this.managerType = managerType;
        this.departmentName = departmentName;
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

    /** Employment category (full-time, part-time, contract). */
    public abstract String getEmploymentType();

    public String getSummary() {
        return name + " | " + getEmploymentType() + " | " + managerType + " | " + departmentName;
    }
}
