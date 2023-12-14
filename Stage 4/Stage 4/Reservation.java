import java.time.LocalDate;

public class Reservation 
{
    private int reservationNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    private Guest guest;
    // Constructor
    public Reservation(int reservationNumber, LocalDate startDate, LocalDate endDate, Room room, Guest guest) {
        this.reservationNumber = reservationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guest = guest;
    }

    // Getter methods
    public int getReservationNumber() 
    {
        return reservationNumber;
    }

    public LocalDate getStartDate() 
    {
        return startDate;
    }

    public LocalDate getEndDate() 
    {
        return endDate;
    }

    public Room getRoom() 
    {
        return room;
    }

    public Guest getGuest() 
    {
        return guest;
    }

    // Setter methods
    public void setStartDate(LocalDate startDate) 
    {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) 
    {
        this.endDate = endDate;
    }

    @Override
    public String toString() 
    {
        return "Reservation Details:\n" +
               "Reservation Number: " + reservationNumber + "\n" +
               "Start Date: " + startDate + "\n" +
               "End Date: " + endDate + "\n" +
               "Room: " + (room != null ? room.getRoomNumber() : "None") + "\n" +
               "Guest: " + (guest != null ? guest.getName(): "None") + "\n";
    }
}
