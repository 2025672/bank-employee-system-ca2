package CA_2;

public class MarketingDepartment extends Department {

    public MarketingDepartment() {
        super("Marketing");
    }

    @Override
    public String getDepartmentCode() {
        return "MKT";
    }
}
