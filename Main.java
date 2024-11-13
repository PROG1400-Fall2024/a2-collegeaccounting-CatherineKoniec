// Student: Catherine Koniec
// Student #: W0497826
// Description: Assignment 2 - College Accounting Application

import javax.swing.*;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

// Main application for college accounting system (handles student fees and staff payroll processing)
public class Main {
    // Lists to store students and staff
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();

    // Application entry point: Creates instance of Main and starts the program
    public static void main(String[] args) {
        new Main().run();
    }

    // Main program loop: Displays option dialog for user selection between Student, Staff, or Finish
    public void run() {
        while (true) {
            String[] options = {"Student", "Staff", "Finish"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Select Student or Staff.",
                    "Accounting App",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            // Handling exit condition
            if (choice == 2 || choice == -1) {
                if (!students.isEmpty() || !staff.isEmpty()) {
                    generateReport();
                }
                break;
            }

            // Processing user selection
            if (choice == 0) {
                addStudent();
            } else {
                addStaff();
            }
        }
    }
    /* Handles the addition of a new student:
     * Validates student year (1-4)
     * Collects and validates name and address
     * Creates new student object and adds to collection
     */
    private void addStudent() {
        try {
            String yearStr = getValidInput("Enter student year (1-4)");
            int year = Integer.parseInt(yearStr);
            if (year < 1 || year > 4) {
                JOptionPane.showMessageDialog(null, "Year must be between 1 and 4");
                return;
            }

            String name = getValidInput("Enter Student Name");
            String address = getValidInput("Enter Student Address");

            students.add(new Student(name, address, year));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }
    /* Adding new staff member to system:
     * Validates years of service (0-30)
     * Collects and validates name and address
     * Creates new Staff object and adds to collection
     */
    private void addStaff() {
        try {
            String name = getValidInput("Enter Staff Name");
            String address = getValidInput("Enter Staff Address");
            String yearsStr = getValidInput("Enter staff years of service");

            int years = Integer.parseInt(yearsStr);
            if (years < 0 || years > 30) {
                JOptionPane.showMessageDialog(null, "Years must be between 0 and 30");
                return;
            }

            staff.add(new Staff(name, address, years));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }
    // Validating user input: Ensures input is not null or empty
    private String getValidInput(String prompt) {
        String input = JOptionPane.showInputDialog(prompt);
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            throw new IllegalArgumentException("Invalid input");
        }
        return input.trim();
    }
    /* Generates final financial report
     * Calculates total incoming fees from students
     * Calculates total outgoing payments to staff
     * Displays formatted report with all details and totals
     */
    private void generateReport() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder report = new StringBuilder();

        double totalOutgoing = 0;
        double totalIncoming = 0;
        // Adding student section
        report.append("Students: [Total: ").append(students.size()).append("]\n");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            report.append(i + 1).append(".").append(student.toString()).append("\n");
            totalIncoming += student.getInstallment();
        }

        // Adding staff section
        report.append("\nStaff: [Total: ").append(staff.size()).append("]\n");
        for (int i = 0; i < staff.size(); i++) {
            Staff staffMember = staff.get(i);
            report.append(i + 1).append(".").append(staffMember.toString()).append("\n");
            totalOutgoing += staffMember.getBiWeeklyPay();
        }

// Adding financial summary
        report.append("\nResults:\n");
        report.append("Outgoing: ").append(currencyFormatter.format(totalOutgoing)).append("\n");
        report.append("Incoming: ").append(currencyFormatter.format(totalIncoming)).append("\n");
        report.append("Total: ").append(currencyFormatter.format(totalIncoming - totalOutgoing));

        JOptionPane.showMessageDialog(null, report.toString(), "Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
