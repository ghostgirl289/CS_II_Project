public class Employee {
    private String name;
    private int id;
    public String getId;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // toString method for display
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name;
    }

    public class Manager extends Employee {
    private String department;

    public Manager(String name, int id, String department) {
        super(name, id); // Call to the superclass (Employee) constructor
        this.department = department;
    }

    // Getter and Setter for the department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Overriding the toString method for Manager specifics
    @Override
    public String toString() {
        return "Manager ID: " + getId() + ", Name: " + getName() + ", Department: " + department;
    }

    // Additional manager-specific methods can be added here
}
}