package CA_2;

/**
 * Menu options for the bank employee system.
 * Uses an Enum as required by the assignment (structured, easy to extend).
 */
public enum MenuOption {

    READ_FILE(1, "Read Applicants_Form.txt"),
    SORT_LIST(2, "Sort employee list (show first 20 names)"),
    SEARCH_LIST(3, "Search employee by name"),
    ADD_EMPLOYEE(4, "Add new employee"),
    CREATE_BINARY_TREE(5, "Create employee hierarchy binary tree"),
    DISPLAY_BINARY_TREE(6, "Display binary tree (level-order, height, count)"),
    EXIT(7, "Exit");

    private final int code;
    private final String label;

    MenuOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Prints every menu option by iterating through the enum values.
     */
    public static void printAllOptions() {
        System.out.println("Please select an option:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.code + ". " + option.label);
        }
    }

    /**
     * Finds a menu option matching the user's numeric choice.
     *
     * @param choice number entered by the user
     * @return matching MenuOption, or null if invalid
     */
    public static MenuOption fromCode(int choice) {
        for (MenuOption option : MenuOption.values()) {
            if (option.code == choice) {
                return option;
            }
        }
        return null;
    }
}
