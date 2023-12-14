// Define a class named "Amenities"
public class Amenities {
    // Private member variable to store the name of the amenity
    private String name;

    // Constructor: Initializes an Amenity object with a name
    public Amenities(String name) {
        this.name = name; // Assign the provided name to the 'name' member variable
    }

    // Getter method to retrieve the name of the amenity
    public String getName() {
        return name;
    }

    // Setter method to set the name of the amenity
    public void setName(String name) {
        this.name = name;
    }

    // toString method for display purposes
    @Override
    public String toString() {
        return "Amenity: " + name; // Returns a string representation of the amenity
    }
}