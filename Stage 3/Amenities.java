public class Amenities {
    private String name;

    public Amenities(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method for display
    @Override
    public String toString() {
        return "Amenity: " + name;
    }
}