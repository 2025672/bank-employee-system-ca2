package CA_2;

/** Part-time bank employee. */
public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, String managerType, String departmentName) {
        super(name, managerType, departmentName);
    }

    @Override
    public String getEmploymentType() {
        return "Part-time";
    }
}
