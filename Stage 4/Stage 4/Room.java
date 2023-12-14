import java.util.Objects;

public class Room {
    private int number;
    private String type;
    private double price;
    private Status status;
    private Guest currentGuest; // To track the current guest in the room

    public enum Status {
        AVAILABLE, BOOKED, UNDER_MAINTENANCE
    }

    public Room(int number, String type, double price, Room.Status status) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.status = status;
        this.currentGuest = null; // Initially, no guest is in the room
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

    public Status getStatus() {
        return status;
    }

    public Guest getCurrentGuest() {
        return currentGuest;
    }

    // Setter methods with validation
    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Method to update room details
    public void updateRoomDetails(String newType, double newPrice) {
        setType(newType);
        setPrice(newPrice);
    }

    // Check-in method
    public void checkIn(Guest guest) {
        if (this.status == Status.AVAILABLE) {
            this.status = Status.BOOKED;
            this.currentGuest = guest;
        } else {
            // Handle this according to your application needs
            System.out.println("Room is not available.");
        }
    }

    // Check-out method
    public void checkOut() {
        if (this.status == Status.BOOKED) {
            this.status = Status.AVAILABLE;
            this.currentGuest = null;
        }
    }

    @Override
    public String toString() {
        return "Room{" +
               "number=" + number +
               ", type='" + type + '\'' +
               ", price=" + price +
               ", status='" + status + '\'' +
               ", currentGuest=" + (currentGuest != null ? currentGuest.getName() : "None") +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}