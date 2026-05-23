package CA_2;

/** Human Resources department. */
public class HRDepartment extends Department {

    public HRDepartment() {
        super("HR");
    }

    @Override
    public String getDepartmentCode() {
        return "HR";
    }
}
