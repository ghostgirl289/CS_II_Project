public class Payment 
{
    private double amount;
    private String type; // e.g., "Credit Card", "Cash", etc.
    private Reservation reservation;

    // Constructor
    public Payment(double amount, String type, Reservation reservation) 
    {
        this.amount = amount;
        this.type = type;
        this.reservation = reservation;
    }

    // Getter methods
    public double getAmount() 
    {
        return amount;
    }

    public String getType() 
    {
        return type;
    }

    public Reservation getReservation() 
    {
        return reservation;
    }

    // Setter methods
    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    @Override
    public String toString() 
    {
        return "Payment Details:\n" +
               "Amount: " + amount + "\n" +
               "Type: " + type + "\n" +
               "Reservation: " + (reservation != null ? reservation.toString() : "None") + "\n";
    }
 }