package CA_2;

/** Senior manager — experienced management role. */
public class SeniorManager extends Manager {

    public SeniorManager() {
        super("Senior Manager");
    }

    @Override
    public String describeRole() {
        return "Manages strategic decisions and senior staff in the department.";
    }
}
