import java.util.Optional;

public class Room {
    private int number;
    private String type;
    private double price;
    private String status;
    private Optional<Guest> guest;

    // Constructor
    public Room(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.status = "Available";
        this.guest = Optional.empty();
    }

    // Getter methods
    public int getRoomNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Optional<Guest> getGuest() {
        return guest;
    }

    // Methods to directly retrieve guest's details
    public String getGuestName() {
        return guest.map(Guest::getName).orElse("No guest");
    }


    // Setter methods
    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Business methods
    public void checkIn(Guest g) {
        this.guest = Optional.of(g);
        this.status = "Occupied";
    }

    public void checkOut() {
        this.guest = Optional.empty();
        this.status = "Available";
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", guest=" + guest +
                '}';
    }
}