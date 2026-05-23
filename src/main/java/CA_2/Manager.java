package CA_2;

/** Parent class for manager roles in the bank. */
public abstract class Manager {

    protected String roleTitle;

    protected Manager(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    /** Describes the management responsibilities. */
    public abstract String describeRole();
}
