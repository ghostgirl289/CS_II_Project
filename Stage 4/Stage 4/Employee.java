public class Employee {
    private String name;
    private int id;
    private String department;

    // Constructor: Initializes an Employee object with name, id, and department
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // Getters to retrieve the values of private fields
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    // Setters to modify the values of private fields
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to update employee details by providing new name and department
    public void updateEmployeeDetails(String newName, String newDepartment) {
        setName(newName);          // Update the name
        setDepartment(newDepartment);  // Update the department
    }

    // toString method to provide a string representation of the Employee object
    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", department='" + department + '\'' +
               '}';
    }

    // Nested class "Manager" that inherits from "Employee"
    public class Manager extends Employee {

        // Constructor for Manager that calls the superclass constructor
        public Manager(String name, int id, String department) {
            super(name, id, department); // Correctly initialize the inherited fields
        }

        // Since department is already in the Employee class, there's no need for a separate field or its getters and setters

        // Override the toString method to provide a specific representation for Managers
        @Override
        public String toString() {
            return "Manager{" +
                   "ID: " + getId() +
                   ", Name: " + getName() +
                   ", Department: " + getDepartment() +
                   '}';
        }
    }
}