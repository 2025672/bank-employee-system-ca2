package CA_2;

/** IT Development department. */
public class ITDevelopmentDepartment extends Department {

    public ITDevelopmentDepartment() {
        super("IT Development");
    }

    @Override
    public String getDepartmentCode() {
        return "IT";
    }
}
