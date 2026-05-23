package CA_2;

/** Full-time bank employee. */
public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, String managerType, String departmentName) {
        super(name, managerType, departmentName);
    }

    @Override
    public String getEmploymentType() {
        return "Full-time";
    }
}
