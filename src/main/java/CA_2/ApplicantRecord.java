package CA_2;

/**
 * One row from Applicants_Form.txt (employee / applicant data).
 */
public class ApplicantRecord {

    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String email;
    private final double salary;
    private final String department;
    private final String position;
    private final String jobTitle;
    private final String company;

    public ApplicantRecord(String firstName, String lastName, String gender, String email,
                           double salary, String department, String position,
                           String jobTitle, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    /** Full name used for sorting and searching. */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    /** Department name (CA search result). */
    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    /** Manager type / role from file (CA search result). */
    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + jobTitle + " | " + department + " | " + company;
    }
}
