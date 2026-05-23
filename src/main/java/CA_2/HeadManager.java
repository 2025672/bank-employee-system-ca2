package CA_2;

/** Head manager — top-level branch leadership. */
public class HeadManager extends Manager {

    public HeadManager() {
        super("Head Manager");
    }

    @Override
    public String describeRole() {
        return "Leads the full bank branch and all department managers.";
    }
}
