package CA_2;

/** Finance department. */
public class FinanceDepartment extends Department {

    public FinanceDepartment() {
        super("Finance");
    }

    @Override
    public String getDepartmentCode() {
        return "FIN";
    }
}
