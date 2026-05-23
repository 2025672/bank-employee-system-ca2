package CA_2;

/** Bank departments for new employee input (Enum). */
public enum DepartmentType {

    CUSTOMER_SERVICE(1, "Customer Service"),
    FOREIGN_EXCHANGE(2, "Foreign Exchange"),
    HR(3, "HR");

    private final int code;
    private final String label;

    DepartmentType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static void printOptions() {
        System.out.println("Please select the Department:");
        for (DepartmentType dept : DepartmentType.values()) {
            System.out.println(dept.code + ". " + dept.label);
        }
    }

    public static DepartmentType fromCode(int code) {
        for (DepartmentType dept : DepartmentType.values()) {
            if (dept.code == code) {
                return dept;
            }
        }
        return null;
    }
}
