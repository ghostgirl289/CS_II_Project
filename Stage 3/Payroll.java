public class Payroll {
    private int employeeID;
    private int employeeHours;
    private double employeePay;
    
    // Constructor
    public Payroll(int employeeID) {
        this.employeeID = employeeID;
    }
    
    // Method to calculate tax (placeholder implementation)
    public void taxCalc(double taxRate) {
        // Placeholder: Implement tax calculation logic here
    }
    
    // Method to set the hours worked
    public void hoursWorked(int hours) {
        this.employeeHours = hours;
    }
    
    // Method to calculate total pay
    public double totalPay(double payRate) {
        employeePay = employeeHours * payRate;
        return employeePay;
    }
    
    // Getter and Setter methods for employeeID
    public int getEmployeeID() {
        return employeeID;
    }
    
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    // Getter and Setter methods for employeeHours
    public int getEmployeeHours() {
        return employeeHours;
    }
    
    public void setEmployeeHours(int employeeHours) {
        this.employeeHours = employeeHours;
    }
    
    // Getter for employeePay
    public double getEmployeePay() {
        return employeePay;
    }
    
    // Override toString method for better readability
    @Override
    public String toString() {
        return "Payroll{" +
               "employeeID=" + employeeID +
               ", employeeHours=" + employeeHours +
               ", employeePay=" + employeePay +
               '}';
    }
}