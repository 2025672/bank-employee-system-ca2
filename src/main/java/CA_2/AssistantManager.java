package CA_2;

/** Assistant manager — supports daily department operations. */
public class AssistantManager extends Manager {

    public AssistantManager() {
        super("Assistant Manager");
    }

    @Override
    public String describeRole() {
        return "Assists the head manager and supervises team activities.";
    }
}
