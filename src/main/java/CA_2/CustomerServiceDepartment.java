package CA_2;

/** Customer Service department. */
public class CustomerServiceDepartment extends Department {

    public CustomerServiceDepartment() {
        super("Customer Service");
    }

    @Override
    public String getDepartmentCode() {
        return "CS";
    }
}
