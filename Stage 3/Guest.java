public class Guest {
    private String name;
    private String phoneNumber;
    private int id;

    public Guest(String name, String phoneNumber, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId()
    {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addGuest()
    {

    }

    @Override
    public String toString() {
        return "Guest{" +
               "name='" + name + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               '}';
    }
}