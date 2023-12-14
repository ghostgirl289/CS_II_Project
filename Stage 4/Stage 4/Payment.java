public class Payment 
{
    private static double amount;
    private String type; // e.g., "Credit Card", "Cash", etc.
    private Reservation reservation;

    // Constructor
    public Payment(double amount, String type, Reservation reservation) {
        setAmount(amount);
        setType(type);
        setReservation(reservation);
    }

    // Getter methods
    public static double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Reservation getReservation() {
        return reservation;
    }

    // Setter methods
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
    }

    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Payment type cannot be null or empty.");
        }
    }

    public void setReservation(Reservation reservation) {
        if (reservation != null) {
            this.reservation = reservation;
        } else {
            throw new IllegalArgumentException("Reservation cannot be null.");
        }
    }

    @Override
    public String toString() {
        return "Payment Details:\n" +
               "Amount: " + amount + "\n" +
               "Type: " + type + "\n" +
               "Reservation: " + (reservation != null ? reservation.toString() : "None") + "\n";
    }
}