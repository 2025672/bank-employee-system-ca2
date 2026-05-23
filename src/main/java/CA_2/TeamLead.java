package CA_2;

/** Team lead — leads a small team within a department. */
public class TeamLead extends Manager {

    public TeamLead() {
        super("Team Lead");
    }

    @Override
    public String describeRole() {
        return "Coordinates tasks for a specific team within the department.";
    }
}
