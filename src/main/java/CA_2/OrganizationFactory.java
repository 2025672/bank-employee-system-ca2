package CA_2;

/**
 * Builds Manager, Department, and Employee objects from records or menu choices.
 */
public class OrganizationFactory {

    private OrganizationFactory() {
    }

    public static Manager createManager(ManagerType type) {
        switch (type) {
            case HEAD_MANAGER:
                return new HeadManager();
            case ASSISTANT_MANAGER:
                return new AssistantManager();
            case TEAM_LEAD:
                return new TeamLead();
            default:
                return null;
        }
    }

    public static Department createDepartment(DepartmentType type) {
        switch (type) {
            case CUSTOMER_SERVICE:
                return new CustomerServiceDepartment();
            case FOREIGN_EXCHANGE:
                return new ForeignExchangeDepartment();
            case HR:
                return new HRDepartment();
            default:
                return null;
        }
    }

    /** Maps file position text to an Employee subtype (full-time, part-time, or contract). */
    public static Employee createEmployeeFromRecord(ApplicantRecord record) {
        String name = record.getFullName();
        String managerType = record.getJobTitle();
        String department = record.getDepartment();
        String position = record.getPosition().toLowerCase();

        if (position.contains("contract")) {
            return new ContractEmployee(name, managerType, department);
        }
        if (position.contains("intern") || position.contains("junior")) {
            return new PartTimeEmployee(name, managerType, department);
        }
        return new FullTimeEmployee(name, managerType, department);
    }
}
