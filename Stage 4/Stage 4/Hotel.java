import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static ArrayList<Room> rooms;
    private static ArrayList<Employee> employees;
    private static ArrayList<Guest> guests;
    private static ArrayList<Reservation> reservations;
    private static List<Payment> allPayments = new ArrayList<>();

    // Constructor
    public Hotel(String name) {
        rooms = new ArrayList<>();
        employees = new ArrayList<>();
        guests = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Check if an employee ID is already taken
    public boolean isEmployeeIDTaken(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Room Management
    public static void addRoom(Room room) {
        rooms.add(room);
    }

    public static Room getOneRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public static boolean removeRoom(int roomNumber) {
        if (rooms == null) {
            rooms = new ArrayList<>(); // Initialize if null
        }
        return rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    public static ArrayList<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    public static boolean editRoom(int roomNumber, String roomType, double roomPrice, Room.Status status) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setType(roomType);
                room.setPrice(roomPrice);
                room.setStatus(status);
                return true; // Room edited successfully
            }
        }
        return false; // Room not found
    }

    // Employee Management
    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    public static boolean removeEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // Guest Management
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public static Guest getGuest(int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null; // Guest not found
    }

    public static boolean removeGuest(int id) {
        return guests.removeIf(guest -> guest.getId() == id);
    }

    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests);
    }

    // Reservation Management
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Reservation getReservation(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationNumber() == reservationId) {
                return reservation;
            }
        }
        return null; // Reservation not found
    }

    public boolean removeReservation(int reservationId) {
        return reservations.removeIf(reservation -> reservation.getReservationNumber() == reservationId);
    }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public static List<Payment> getAllPayments() {
        // Assuming there's a direct list of payments in the Hotel class
        return new ArrayList<>(allPayments);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : Hotel.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    public boolean isGuestIDTaken(int id) {
        for (Guest guest : Hotel.guests) {
            if (guest.getId() == id) {
                return true; // ID is already taken by an existing guest
            }
        }
        return false; // No existing guest has this ID
    }
}
