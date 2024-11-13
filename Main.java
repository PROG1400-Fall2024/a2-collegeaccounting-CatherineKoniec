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
    /* Handles the addition of a new student
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
