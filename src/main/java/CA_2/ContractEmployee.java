package CA_2;

/** Contract bank employee. */
public class ContractEmployee extends Employee {

    public ContractEmployee(String name, String managerType, String departmentName) {
        super(name, managerType, departmentName);
    }

    @Override
    public String getEmploymentType() {
        return "Contract";
    }
}
