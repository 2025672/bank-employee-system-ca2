package CA_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads and parses Applicants_Form.txt (CSV format).
 */
public class FileHandler {

    private static final int EXPECTED_COLUMNS = 9;

    private FileHandler() {
    }

    /**
     * Loads applicant records from a CSV file.
     *
     * @param filename file name or path entered by the user
     * @return list of parsed records
     * @throws IOException if the file cannot be found or read
     */
    public static List<ApplicantRecord> readApplicantsFile(String filename) throws IOException {
        File file = findFile(filename);
        if (file == null) {
            throw new IOException("File not found: " + filename);
        }

        List<ApplicantRecord> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                throw new IOException("File is empty.");
            }

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                ApplicantRecord record = parseLine(line, lineNumber);
                list.add(record);
            }
        }

        if (list.isEmpty()) {
            throw new IOException("No employee records found in file.");
        }

        return list;
    }

    /**
     * Tries common locations: current folder, project resources folder.
     */
    private static File findFile(String filename) {
        String[] paths = {
            filename,
            "src/main/resources/" + filename,
            "src\\main\\resources\\" + filename
        };

        for (String path : paths) {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                return file;
            }
        }
        return null;
    }

    /**
     * Parses one CSV line into an ApplicantRecord.
     * Format: First name, Last name, Gender, Email, Salary, Department, Position, Job title, Company
     */
    private static ApplicantRecord parseLine(String line, int lineNumber) throws IOException {
        String[] parts = line.split(",", -1);

        if (parts.length != EXPECTED_COLUMNS) {
            throw new IOException("Invalid data at line " + lineNumber
                    + " (expected " + EXPECTED_COLUMNS + " columns, found " + parts.length + ").");
        }

        String firstName = parts[0].trim();
        String lastName = parts[1].trim();
        String gender = parts[2].trim();
        String email = parts[3].trim();
        String department = parts[5].trim();
        String position = parts[6].trim();
        String jobTitle = parts[7].trim();
        String company = parts[8].trim();

        double salary;
        try {
            salary = Double.parseDouble(parts[4].trim());
        } catch (NumberFormatException e) {
            throw new IOException("Invalid salary at line " + lineNumber + ".");
        }

        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IOException("Missing name at line " + lineNumber + ".");
        }

        return new ApplicantRecord(firstName, lastName, gender, email, salary,
                department, position, jobTitle, company);
    }
}
