// Staff class for managing employee information and payroll
public class Staff extends Person {
    private int yearsOfService;
    private double salary;

    /*Constructor for Staff
     * Calculates salary based on years of service using private implementation
     * Base salary is $50000 with $500 step increase per year
     */
    public Staff(String name, String address, int yearsOfService) {
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.salary = 50000 + (yearsOfService * 500);
    }
    // Calculating bi-weekly pay (yearly salary divided by 26)
    public double getBiWeeklyPay() {
        return salary / 26;
    }