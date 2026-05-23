package CA_2;

public class TechnicalSupportDepartment extends Department {

    public TechnicalSupportDepartment() {
        super("Technical Support");
    }

    @Override
    public String getDepartmentCode() {
        return "TS";
    }
}
