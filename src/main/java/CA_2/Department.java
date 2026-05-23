package CA_2;

/** Parent class for bank departments. */
public abstract class Department {

    protected String departmentName;

    protected Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    /** Short code used to identify the department. */
    public abstract String getDepartmentCode();
}
