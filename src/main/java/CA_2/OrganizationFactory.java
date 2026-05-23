package CA_2;

/**
 * Creates Manager and Department objects from validated enum choices.
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
            case SENIOR_MANAGER:
                return new SeniorManager();
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
            case FINANCE:
                return new FinanceDepartment();
            case IT_DEVELOPMENT:
                return new ITDevelopmentDepartment();
            case SALES:
                return new SalesDepartment();
            case MARKETING:
                return new MarketingDepartment();
            case ACCOUNTING:
                return new AccountingDepartment();
            case OPERATIONS:
                return new OperationsDepartment();
            case TECHNICAL_SUPPORT:
                return new TechnicalSupportDepartment();
            default:
                return null;
        }
    }

    /**
     * Builds an Employee subtype from file data using the position field.
     */
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
