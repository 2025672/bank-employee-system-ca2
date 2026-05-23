package CA_2;

public class AccountingDepartment extends Department {

    public AccountingDepartment() {
        super("Accounting");
    }

    @Override
    public String getDepartmentCode() {
        return "ACC";
    }
}
