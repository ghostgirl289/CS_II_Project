public class Guest {
    private String name;
    private String phoneNumber;
    private int id;

    // Constructor: Initializes a Guest object with name, phoneNumber, and id
    public Guest(String name, String phoneNumber, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    // Getter methods to retrieve the values of private fields
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    // Setter methods to modify the values of private fields
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Method to update guest details by providing a new id, name, and phoneNumber
    public void updateGuestDetails(int id, String newName, String newPhoneNumber) {
        setId(id);              // Update the id
        setName(newName);       // Update the name
        setPhoneNumber(newPhoneNumber);  // Update the phoneNumber
    }

    // Override toString method to provide a string representation of the Guest object
    @Override
    public String toString() {
        return "Guest{" +
               "name='" + name + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", id=" + id +
               '}';
    }
}