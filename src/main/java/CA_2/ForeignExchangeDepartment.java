package CA_2;

/** Foreign Exchange department. */
public class ForeignExchangeDepartment extends Department {

    public ForeignExchangeDepartment() {
        super("Foreign Exchange");
    }

    @Override
    public String getDepartmentCode() {
        return "FX";
    }
}
