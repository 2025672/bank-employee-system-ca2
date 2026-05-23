package CA_2;

/** Manager roles for new employee input (Enum). */
public enum ManagerType {

    HEAD_MANAGER(1, "Head Manager"),
    ASSISTANT_MANAGER(2, "Assistant Manager"),
    TEAM_LEAD(3, "Team Lead");

    private final int code;
    private final String label;

    ManagerType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static void printOptions() {
        System.out.println("Please select from the following Management Staff:");
        for (ManagerType type : ManagerType.values()) {
            System.out.println(type.code + ". " + type.label);
        }
    }

    public static ManagerType fromCode(int code) {
        for (ManagerType type : ManagerType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}
