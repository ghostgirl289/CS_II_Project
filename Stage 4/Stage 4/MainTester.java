import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainTester 
{
    private static Hotel hotel = new Hotel("Grandiose Hotel");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        initializeDummyData();
        HotelManagementGUI.launchGUI();

                boolean exit = false;
                while (!exit) {
                System.out.println("\n--- Hotel Management System ---");
                System.out.println("1. Manage Employees");
                System.out.println("2. Manage Guests");
                System.out.println("3. Manage Rooms");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) 
                {
                        case 1:
                                manageEmployees();
                                break;
                        case 2:
                                manageGuests();
                                break;
                        case 3:
                                manageRooms();
                                break;
                        case 4:
                                exit = true;
                                break;
                        default:
                        System.out.println("Invalid option, please try again.");
                }
    }
}

private static void initializeDummyData()
{
        // Create guests
        Guest guest1 = new Guest("John Doe", "575-518-1234", 202);
        Guest guest2 = new Guest("Jane Smith", "575-447-0613", 203);
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        
        // Create rooms
        Room room1 = new Room(101, "Single", 100.0, Room.Status.BOOKED);
        Room room2 = new Room(102, "Double", 150.0, Room.Status.BOOKED);


        // Add rooms to hotel
        Hotel.addRoom(room1);
        Hotel.addRoom(room2);

        // Create employees
        Employee manager = new Employee("Alice Williams", 201, "Hotel Manager");

        // Add employees to hotel
        Hotel.addEmployee(manager);

        // Create reservations
        Reservation reservation1 = new Reservation(1, LocalDate.now(), LocalDate.now().plusDays(3), room1, guest1);
        Reservation reservation2 = new Reservation(2, LocalDate.now(), LocalDate.now().plusDays(5), room2, guest2);

        // Simulate room check-in
        room1.checkIn(guest1);
        room2.checkIn(guest2);

        room1.setStatus(Room.Status.BOOKED);
        room2.setStatus(Room.Status.BOOKED);


        // Create payments
        Payment payment1 = new Payment(300.0, "Credit Card", reservation1);
        Payment payment2 = new Payment(750.0, "Cash", reservation2);

        // Print details
        System.out.println("Hotel Details:");
        System.out.println(hotel);
        System.out.println("\nGuest Details:");
        System.out.println(guest1);
        System.out.println(guest2);
        System.out.println("\nRoom Details:");
        System.out.println(room1);
        System.out.println(room2);
        System.out.println("\nEmployee Details:");
        for (Employee e : hotel.getAllEmployees()) {
        System.out.println(e);
        }
        System.out.println("\n");
        System.out.println(reservation1);
        System.out.println(reservation2);
        System.out.println(payment1);
        System.out.println(payment2);
}
    private static void manageEmployees() 
    {
        boolean back = false;
        while (!back) 
        {
        System.out.println("\n--- Manage Employees ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) 
            {
                case 1:
                addEmployee();
                break;
                case 2:
                viewEmployees();
                break;
                case 3:
                updateEmployee();
                break;
                case 4:
                deleteEmployee();
                break;
                case 5:
                back = true;
                break;
                default:
                System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addEmployee() {
        int id;
        while (true) 
        {
            System.out.print("Enter employee ID: ");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (!hotel.isEmployeeIDTaken(id)) { // Assuming such a method exists
                    break;
                } else {
                    System.out.println("This ID is already taken. Please enter a different ID.");
                }
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter Employee Department: ");
        String department = scanner.nextLine();

    
        Employee employee = new Employee(name, id, department);
        Hotel.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() 
    {
        // Assuming hotel class has a method to get all employees
        List<Employee> employees = hotel.getAllEmployees();
        for (Employee employee : employees) 
        {
                System.out.println(employee); // Assuming Employee class has a toString method
        }
    }

    private static void updateEmployee() 
    {
        System.out.println("Enter employee ID to update: ");
        int id = scanner.nextInt();

        Employee employee = hotel.findEmployeeById(id);
        if (employee != null) 
        {
        System.out.print("Enter new first name for employee: ");
        String newName = scanner.nextLine();
        employee.setName(newName);  // Assuming separate setters for first and last name
        System.out.println("Employee updated successfully.");
        } else 
        {
        System.out.println("Employee not found.");
        }
    }
        // Delete Employee method
        private static void deleteEmployee() 
        {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        // Assuming hotel class has a method to remove an employee
        boolean isDeleted = hotel.removeEmployee(id);
        if (isDeleted) 
        {
                System.out.println("Employee deleted successfully.");
        } else 
        {
                System.out.println("Employee not found or could not be deleted.");
        }

        }
    

        private static void manageGuests()
        {
                int choice;

                do 
                {
                System.out.println("Guest Management Menu:");
                System.out.println("1. Add New Guest");
                System.out.println("2. View Guests");
                System.out.println("3. Update Guest Information");
                System.out.println("4. Delete Guest");
                System.out.println("0. Return to Main Menu");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) 
                {
                        case 1:
                                addGuest();
                                break;
                        case 2:
                                viewGuests();
                                break;
                        case 3:
                                updateGuest();
                                break;
                        case 4:
                                removeGuest();
                                break;
                        case 0:
                                break;
                        default:
                        System.out.println("Invalid choice. Please try again.");
                }
                } while (choice != 0);
        }
        
        private static void addGuest() {

                System.out.print("Enter guest name: ");
                String name = scanner.nextLine();

                System.out.print("Enter guest Phone number: ");
                String phoneNumber = scanner.nextLine();

                System.out.println("Enter guest ID: ");
                int id = scanner.nextInt();

                Guest guest = new Guest(name, phoneNumber, id);
                hotel.addGuest(guest);

        }

        private static void viewGuests() {
                // Assuming the Hotel class has a method to get all guests
                List<Guest> guests = hotel.getAllGuests();
                if (guests.isEmpty()) {
                    System.out.println("No guests currently registered in the hotel.");
                } else {
                    for (Guest guest : guests) {
                        System.out.println("Guest ID: " + guest.getId() + ", Name: " + guest.getName() + ", Phone: " + guest.getPhoneNumber());
                    }
                }
            }

        private static void updateGuest() 
        {
                // Similar to updateEmployee method
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Guest ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                List<Guest> guests = hotel.getAllGuests();

                for (Guest guest : guests) 
                {
                if (guest.getId() == id) {
                        System.out.print("Enter new name for Guest: ");
                        String newName = scanner.nextLine();
                        guest.setName(newName);
                        System.out.println("Guest updated successfully.");
                        return;
                }
                }
                System.out.println("Guest not found.");

        }

        private static void removeGuest() {
                System.out.print("Enter guest ID to delete: ");
                int guestId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            
                // Assuming guests are stored in a list within the Hotel class and have an integer ID
                boolean isDeleted = hotel.removeGuest(guestId);
                if (isDeleted) {
                    System.out.println("Guest deleted successfully.");
                } else {
                    System.out.println("Guest not found or could not be deleted.");
                }
            }

        private static void manageRooms() 
        {
                int choice;
                
                do {
                        System.out.println("Room Management Menu:");
                        System.out.println("1. Add New Room");
                        System.out.println("2. View Rooms");
                        System.out.println("3. Update Room Information");
                        System.out.println("4. Delete Room");
                        System.out.println("0. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                
                        switch (choice) {
                        case 1:
                                addRoom();
                                break;
                        case 2:
                                viewRooms();
                                break;
                        case 3:
                                updateRoom();
                                break;
                        case 4:
                                deleteRoom();
                                break;
                        case 0:
                                break;
                        default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                } while (choice != 0);

        }
        private static void addRoom() {
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            
                System.out.print("Enter room type (e.g., Single, Double): ");
                String roomType = scanner.nextLine();
            
                System.out.print("Enter price per night: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
            
                System.out.println("Select room status:");
                for (Room.Status status : Room.Status.values()) {
                    System.out.println(status);
                }
                System.out.print("Enter status: ");
                String statusInput = scanner.nextLine();
            
                Room.Status roomStatus;
                try {
                    roomStatus = Room.Status.valueOf(statusInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status entered. Setting to AVAILABLE.");
                    roomStatus = Room.Status.AVAILABLE;
                }
            
                Room newRoom = new Room(roomNumber, roomType, price, roomStatus);
                Hotel.addRoom(newRoom); 
        }
        private static void viewRooms() 
        {
                System.out.println("List of Rooms:");
                for (Room room : Hotel.getRooms()) 
                { // Assuming hotel has a method to get all rooms
                        System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getType() + ", Price: $" + room.getPrice());
                }
        }
        private static void updateRoom() 
        {
            System.out.print("Enter room number to update: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Find the room
            Room roomToUpdate = Hotel.getOneRoom(roomNumber); // Assuming hotel has a method to find a room
            if (roomToUpdate != null) 
            {
                    System.out.print("Enter new room type: ");
                    String newType = scanner.nextLine();
            
                    System.out.print("Enter new price per night: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
            
                    roomToUpdate.setType(newType); // Assuming Room class has setType method
                    roomToUpdate.setPrice(newPrice); // Assuming Room class has setPrice method
                    System.out.println("Room updated successfully.");
            } else 
            {
                    System.out.println("Room not found.");
            }
        }
        private static void deleteRoom() 
        {
        System.out.print("Enter room number to delete: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        boolean isDeleted = Hotel.removeRoom(roomNumber); // Assuming hotel has a method to remove a room
            if (isDeleted) 
            {
                    System.out.println("Room deleted successfully.");
            } else 
            {
                    System.out.println("Room not found or could not be deleted.");
            }
        }

}