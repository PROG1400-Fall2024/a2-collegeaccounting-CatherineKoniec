// Student: Catherine Koniec
// Student #: W0497826
// Description: Assignment 2 - College Accounting Application


/* Student class representing college students
 * Handles student-specific attributes and fee calculations
 * Implements private attributes for year and fees
 * Inherits name and address from Person class
 */
public class Student extends Person {
    private int year;
    private double fees;

    /* Constructor for Student
     * Calculates fees based on year level using private implementation
     * Base fee is $3000 with $100 increment per year
     */
    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        this.fees = 3000 + ((year - 1) * 100);
    }

    // Calculating semester installment (half of total fees)
    public double getInstallment() {
        return fees / 2;
    }

    // Formatting student information for display
    @Override
    public String toString() {
        return String.format("name = %s, address = %s, year = %d, fee = $%.2f",
                getName(), getAddress(), year, fees);
    }
}