package CA_2;

public class SalesDepartment extends Department {

    public SalesDepartment() {
        super("Sales");
    }

    @Override
    public String getDepartmentCode() {
        return "SAL";
    }
}
