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