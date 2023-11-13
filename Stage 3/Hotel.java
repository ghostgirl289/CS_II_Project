import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Employee> employees;
    private ArrayList<Guest> guests;
    private ArrayList<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
        rooms = new ArrayList<>();
        employees = new ArrayList<>();
        guests = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Room Management
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(int roomNumber) {
        return rooms.stream()
                    .filter(room -> room.getRoomNumber() == roomNumber)
                    .findFirst()
                    .orElse(null);
    }

    public boolean removeRoom(int roomNumber) {
        return rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    // Employee Management
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployee(String id) {
        return employees.stream()
                        .filter(employee -> employee.getId == id)
                        .findFirst()
                        .orElse(null);
    }

    public boolean removeEmployee(String id) {
        return employees.removeIf(employee -> employee.getId == id);
    }
    
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); 
    }

    public Employee findEmployeeById(String id) {
        for (Employee employee : this.employees) {
            if (employee.getId == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }

    // Guest Management
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public boolean removeGuest(String id) {
        return guests.removeIf(guest -> guest.equals(id));
    }

    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests);
    }

    // Reservation Management
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Reservation getReservation(int reservationId) {
        return reservations.stream()
                           .filter(reservation -> reservation.getReservationNumber() == reservationId)
                           .findFirst()
                           .orElse(null);
    }

    public boolean removeReservation(int reservationId) {
        return reservations.removeIf(reservation -> reservation.getReservationNumber() == reservationId);
    }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }
}