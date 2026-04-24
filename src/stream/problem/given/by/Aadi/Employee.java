package stream.problem.given.by.Aadi;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String city;

    public Employee(int id, String name, String department, double salary, String city) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.city = city;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }
}