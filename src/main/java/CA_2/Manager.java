package CA_2;

/**
 * Parent class for manager roles (Head Manager, Assistant Manager, Team Lead, etc.).
 */
public abstract class Manager {

    protected String roleTitle;

    public Manager() {
        // Subtypes added in a later commit.
    }

    public String getRoleTitle() {
        return roleTitle;
    }
}
