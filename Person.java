// Student: Catherine Koniec
// Student #: W0497826
// Description: Assignment 2 - College Accounting Application

// Base class for all persons in the system
public abstract class Person {
    private String name;
    private String address;

    // Constructor for Person
    // Initializing person with name and address
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter methods:
    // Retrieves the person's name
    public String getName() {
        return name;
    }
    // Retrieves the person's address
    public String getAddress() {
        return address;
    }

    // Abstract toString method to be implemented by subclasses
    @Override
    public abstract String toString();
}