import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HotelManagementGUI {

    List<Payment> paymentList = new ArrayList<>(); 
    // This method is used to launch the GUI for the Hotel Management System.
    public static void launchGUI() {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame to hold the main application window.
            JFrame frame = new JFrame("Hotel Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create a menu bar for the application.
            JMenuBar menuBar = new JMenuBar();
            frame.setJMenuBar(menuBar);

            // Create and add menus to the menu bar.
            JMenu fileMenu = new JMenu("File");
            JMenu manageMenu = new JMenu("Manage");
            JMenu salesRecordMenu = new JMenu("Sales Records");
            menuBar.add(fileMenu);
            menuBar.add(manageMenu);
            menuBar.add(salesRecordMenu);

            // Create and add menu items for the File menu.
            JMenuItem exitItem = new JMenuItem("Exit");
            fileMenu.add(exitItem);

            // Create and add menu items for the Manage menu.
            JMenuItem manageRoomsItem = new JMenuItem("Rooms");
            JMenuItem manageEmployeesItem = new JMenuItem("Employees");
            JMenuItem manageGuestsItem = new JMenuItem("Guests");
            manageMenu.add(manageRoomsItem);
            manageMenu.add(manageEmployeesItem);
            manageMenu.add(manageGuestsItem);

            // Create and add menu items for the Sales Records menu.
            JMenuItem viewSalesRecordItem = new JMenuItem("View Sales Records");
            JMenuItem generateSalesReportItem = new JMenuItem("Generate Sales Report");
            salesRecordMenu.add(viewSalesRecordItem);
            salesRecordMenu.add(generateSalesReportItem);

            // Define action listeners for menu items.
            // - Exit the application
            exitItem.addActionListener(e -> System.exit(0));
            // - Show room management interface
            manageRoomsItem.addActionListener(e -> showRoomManagement(frame));
            // - Show employee management interface
            manageEmployeesItem.addActionListener(e -> showEmployeeManagement(frame));
            // - Show guest management interface
            manageGuestsItem.addActionListener(e -> showGuestManagement(frame));
            // - View sales records
            viewSalesRecordItem.addActionListener(e -> viewSalesReport(frame));
            // - Generate sales report
            generateSalesReportItem.addActionListener(e -> generateSalesReport(frame));

            // Make the main frame visible.
            frame.setVisible(true);
        });
    }

    // This method displays the room management interface.
    private static void showRoomManagement(JFrame frame) {
        // Create a panel to hold the room management components.
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));

        // Create a title label for the room management section.
        JLabel titleLabel = new JLabel("Room Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a button to add a new room.
        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addRoomButton.addActionListener(e -> showAddRoomDialog(frame));

        // Create a button to view existing rooms.
        JButton viewRoomsButton = new JButton("View Rooms");
        viewRoomsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewRoomsButton.addActionListener(e -> viewRooms(frame));

        // Create a button to edit existing rooms.
        JButton editRoomButton = new JButton("Edit Room");
        editRoomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editRoomButton.addActionListener(e -> showEditRoomDialog(frame));

        // Create a button to delete existing rooms.
        JButton deleteRoomButton = new JButton("Delete Room");
        deleteRoomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteRoomButton.addActionListener(e -> showDeleteRoomDialog(frame));

        // Add components to the room management panel.
        roomPanel.add(titleLabel);
        roomPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        roomPanel.add(addRoomButton);
        roomPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        roomPanel.add(viewRoomsButton);
        roomPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        roomPanel.add(editRoomButton);
        roomPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        roomPanel.add(deleteRoomButton);

        // Set the room management panel as the content pane of the frame.
        frame.setContentPane(roomPanel);
        frame.revalidate(); // Refresh the frame to show the new content.
    }

    // This method displays a dialog for adding a new room.
    private static void showAddRoomDialog(JFrame frame) {
        // Create a dialog to input room details.
        JDialog addRoomDialog = new JDialog(frame, "Add New Room", true);
        addRoomDialog.setLayout(new FlowLayout());

        // Create input fields for room number, type, price, and status.
        JTextField roomNumberField = new JTextField(5);
        JTextField roomTypeField = new JTextField(20);
        JTextField roomPriceField = new JTextField(10);
        JComboBox<Room.Status> statusComboBox = new JComboBox<>(Room.Status.values());

        // Add components to the add room dialog.
        addRoomDialog.add(new JLabel("Room Number:"));
        addRoomDialog.add(roomNumberField);
        addRoomDialog.add(new JLabel("Room Type:"));
        addRoomDialog.add(roomTypeField);
        addRoomDialog.add(new JLabel("Price:"));
        addRoomDialog.add(roomPriceField);
        addRoomDialog.add(new JLabel("Status:"));
        addRoomDialog.add(statusComboBox);

        // Create a button to confirm adding the room.
        JButton confirmButton = new JButton("Add Room");
        confirmButton.addActionListener(e -> {
            try {
                int roomNumber = Integer.parseInt(roomNumberField.getText());
                String roomType = roomTypeField.getText();
                double roomPrice = Double.parseDouble(roomPriceField.getText());
                Room.Status status = (Room.Status) statusComboBox.getSelectedItem();

                // Add the new room to the hotel (Note: Implement this method in your Hotel class).
                Hotel.addRoom(new Room(roomNumber, roomType, roomPrice, status));

                // Close the dialog and show a success message.
                addRoomDialog.dispose();
                JOptionPane.showMessageDialog(frame, "Room added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please ensure correct format.");
            }
        });

        // Add the confirm button to the dialog.
        addRoomDialog.add(confirmButton);

        // Set dialog properties and make it visible.
        addRoomDialog.pack();
        addRoomDialog.setLocationRelativeTo(frame);
        addRoomDialog.setVisible(true);
    }

    // This method displays a list of existing rooms in a table.
    private static void viewRooms(JFrame frame) {
        // Get the list of rooms from the hotel (Note: Implement this method in your Hotel class).
        List<Room> rooms = Hotel.getRooms();

        // Check if there are rooms to display.
        if (rooms == null || rooms.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No rooms data found.");
            return;
        }

        // Define table column names.
        String[] columnNames = {"Room Number", "Room Type", "Price", "Status"};

        // Create a two-dimensional array to hold room data for the table.
        String[][] data = new String[rooms.size()][4];

        // Populate the data array with room information.
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            data[i][0] = String.valueOf(room.getRoomNumber());
            data[i][1] = room.getType();
            data[i][2] = String.valueOf(room.getPrice());
            data[i][3] = room.getStatus().toString();
        }

        // Create a JTable to display the room data.
        JTable roomTable = new JTable(data, columnNames);
        roomTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        roomTable.setFillsViewportHeight(true);

        // Create a JScrollPane to display the table in case of overflow.
        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Create a panel to hold the table.
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Set the table panel as the content pane of the frame.
        frame.setContentPane(tablePanel);
        frame.revalidate(); // Refresh the frame to show the new content.
    }

    // This method displays a dialog for editing an existing room.
    private static void showEditRoomDialog(JFrame frame) {
        // Create a dialog to input edited room details.
        JDialog editRoomDialog = new JDialog(frame, "Edit Room", true);
        editRoomDialog.setLayout(new FlowLayout());

        // Create input fields for room number, type, price, and status.
        JTextField roomNumberField = new JTextField(5);
        JTextField roomTypeField = new JTextField(20);
        JTextField roomPriceField = new JTextField(10);
        JComboBox<Room.Status> statusComboBox = new JComboBox<>(Room.Status.values());

        // Add components to the edit room dialog.
        editRoomDialog.add(new JLabel("Room Number:"));
        editRoomDialog.add(roomNumberField);
        editRoomDialog.add(new JLabel("Room Type:"));
        editRoomDialog.add(roomTypeField);
        editRoomDialog.add(new JLabel("Price:"));
        editRoomDialog.add(roomPriceField);
        editRoomDialog.add(new JLabel("Status:"));
        editRoomDialog.add(statusComboBox);

        // Create a button to confirm editing the room.
        JButton confirmButton = new JButton("Edit Room");
        confirmButton.addActionListener(e -> {
            try {
                int roomNumber = Integer.parseInt(roomNumberField.getText());
                String roomType = roomTypeField.getText();
                double roomPrice = Double.parseDouble(roomPriceField.getText());
                Room.Status status = (Room.Status) statusComboBox.getSelectedItem();

                // Edit the room with the new details (Note: Implement this method in your Hotel class).
                boolean edited = Hotel.editRoom(roomNumber, roomType, roomPrice, status);

                if (edited) {
                    // Close the dialog and show a success message.
                    editRoomDialog.dispose();
                    JOptionPane.showMessageDialog(frame, "Room edited successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Room not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please ensure correct format.");
            }
        });

        // Add the confirm button to the dialog.
        editRoomDialog.add(confirmButton);

        // Set dialog properties and make it visible.
        editRoomDialog.pack();
        editRoomDialog.setLocationRelativeTo(frame);
        editRoomDialog.setVisible(true);
    }

    // This method displays a dialog for deleting an existing room.
    private static void showDeleteRoomDialog(JFrame frame) {
        // Create a dialog to input the room number to delete.
        JDialog deleteRoomDialog = new JDialog(frame, "Delete Room", true);
        deleteRoomDialog.setLayout(new FlowLayout());

        // Create an input field for the room number to delete.
        JTextField roomNumberField = new JTextField(5);

        // Add components to the delete room dialog.
        deleteRoomDialog.add(new JLabel("Room Number to Delete:"));
        deleteRoomDialog.add(roomNumberField);

        // Create a button to confirm deleting the room.
        JButton confirmButton = new JButton("Delete Room");
        confirmButton.addActionListener(e -> {
            try {
                int roomNumber = Integer.parseInt(roomNumberField.getText());

                // Delete the room with the specified room number (Note: Implement this method in your Hotel class).
                boolean deleted = Hotel.removeRoom(roomNumber);

                if (deleted) {
                    // Close the dialog and show a success message.
                    deleteRoomDialog.dispose();
                    JOptionPane.showMessageDialog(frame, "Room deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Room not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid room number.");
            }
        });

        // Add the confirm button to the dialog.
        deleteRoomDialog.add(confirmButton);

        // Set dialog properties and make it visible.
        deleteRoomDialog.pack();
        deleteRoomDialog.setLocationRelativeTo(frame);
        deleteRoomDialog.setVisible(true);
    }
    private static void showEmployeeManagement(JFrame frame) {
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));
    
        JLabel titleLabel = new JLabel("Employee Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeePanel.add(titleLabel);
    
        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeePanel.add(addEmployeeButton);
    
        JButton deleteEmployeeButton = new JButton("Delete Employee");
        deleteEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeePanel.add(deleteEmployeeButton);
    
        JButton updateEmployeeButton = new JButton("Update Employee");
        updateEmployeeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeePanel.add(updateEmployeeButton);
    
        JButton viewEmployeesButton = new JButton("View Employees");
        viewEmployeesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        employeePanel.add(viewEmployeesButton);
    
        frame.setContentPane(employeePanel);
        frame.revalidate();
        frame.repaint();
    
        // Add action listeners for each button
        addEmployeeButton.addActionListener(e -> addNewEmployee(frame));
        deleteEmployeeButton.addActionListener(e -> deleteEmployee(frame));
        updateEmployeeButton.addActionListener(e -> updateEmployee(frame));
        viewEmployeesButton.addActionListener(e -> viewEmployees(frame));
    }
    
    private static void addNewEmployee(JFrame frame) {
        JTextField nameField = new JTextField(10);
        JTextField roleField = new JTextField(10);
        JPanel employeeForm = new JPanel();
        employeeForm.add(new JLabel("Name:"));
        employeeForm.add(nameField);
        employeeForm.add(Box.createHorizontalStrut(15)); // a spacer
        employeeForm.add(new JLabel("Role:"));
        employeeForm.add(roleField);
    
        int result = JOptionPane.showConfirmDialog(frame, employeeForm, 
                "Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String employeeName = nameField.getText();
            String employeeRole = roleField.getText();
            // Add code to create an Employee object and add it to your system
            JOptionPane.showMessageDialog(frame, "Employee Added: " + employeeName + ", Role: " + employeeRole);
        }
    }
    
    private static void deleteEmployee(JFrame frame) {
        JTextField employeeIDField = new JTextField(10);
        JPanel employeeForm = new JPanel();
        employeeForm.add(new JLabel("Employee ID:"));
        employeeForm.add(employeeIDField);
    
        int result = JOptionPane.showConfirmDialog(frame, employeeForm, 
                "Enter Employee ID to Delete", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int employeeID = Integer.parseInt(employeeIDField.getText());
                // Assuming Hotel class has a method to remove an employee by ID
                boolean isDeleted = Hotel.removeEmployee(employeeID);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(frame, "Employee Deleted: ID " + employeeID);
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee Not Found: ID " + employeeID);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid integer.");
            }
        }
    }
    
    private static void updateEmployee(JFrame frame) {
        JTextField employeeIDField = new JTextField(10);
        JTextField newNameField = new JTextField(10);
        JTextField newRoleField = new JTextField(10);
    
        JPanel updateForm = new JPanel();
        updateForm.setLayout(new BoxLayout(updateForm, BoxLayout.Y_AXIS));
        updateForm.add(new JLabel("Employee ID:"));
        updateForm.add(employeeIDField);
        updateForm.add(new JLabel("New Name:"));
        updateForm.add(newNameField);
        updateForm.add(new JLabel("New Role:"));
        updateForm.add(newRoleField);
    
        int result = JOptionPane.showConfirmDialog(frame, updateForm, 
                "Enter Details to Update Employee", JOptionPane.OK_CANCEL_OPTION);
    
        if (result == JOptionPane.OK_OPTION) {
            try {
                int employeeID = Integer.parseInt(employeeIDField.getText());
                Employee employee = Hotel.getEmployee(employeeID);
                if (employee != null) {
                    employee.updateEmployeeDetails(newNameField.getText(), newRoleField.getText());
                    JOptionPane.showMessageDialog(frame, "Employee Updated: ID " + employeeID);
                } else {
                    JOptionPane.showMessageDialog(frame, "Employee Not Found: ID " + employeeID);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid integer.");
            }
        }
    }
    
    private static void viewEmployees(JFrame frame) {
        String[] columnNames = {"Employee ID", "Name", "Role"};
        Object[][] data = {
            {1, "Alice Johnson", "Manager"},
            {2, "Bob Smith", "Receptionist"},
        };
    
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
    
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    
        JDialog dialog = new JDialog(frame, "View Employees", true);
        dialog.add(panel);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private static void showGuestManagement(JFrame frame) {
        JPanel guestPanel = new JPanel();
        guestPanel.setLayout(new BoxLayout(guestPanel, BoxLayout.Y_AXIS));
    
        JLabel titleLabel = new JLabel("Guest Management");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestPanel.add(titleLabel);
    
        JButton addGuestButton = new JButton("Add New Guest");
        addGuestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestPanel.add(addGuestButton);
    
        JButton deleteGuestButton = new JButton("Delete Guest");
        deleteGuestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestPanel.add(deleteGuestButton);
    
        JButton updateGuestButton = new JButton("Update Guest");
        updateGuestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestPanel.add(updateGuestButton);
    
        JButton viewGuestsButton = new JButton("View Guests"); // New button for viewing guests
        viewGuestsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guestPanel.add(viewGuestsButton);
    
        frame.setContentPane(guestPanel);
        frame.revalidate();
        frame.repaint();
    
        addGuestButton.addActionListener(e -> addNewGuest(frame));
        deleteGuestButton.addActionListener(e -> deleteGuest(frame));
        updateGuestButton.addActionListener(e -> updateGuest(frame));
        viewGuestsButton.addActionListener(e -> viewGuests(frame)); // Set action listener for viewGuestsButton
    }
    private static void addNewGuest(JFrame frame) 
    {
        JTextField nameField = new JTextField(10);
        JTextField phoneField = new JTextField(10);
        JPanel guestForm = new JPanel();
        guestForm.add(new JLabel("Name:"));
        guestForm.add(nameField);
        guestForm.add(Box.createHorizontalStrut(15)); // a spacer
        guestForm.add(new JLabel("Phone:"));
        guestForm.add(phoneField);

        int result = JOptionPane.showConfirmDialog(frame, guestForm, 
                "Please Enter Guest Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String guestName = nameField.getText();
            String guestPhone = phoneField.getText();
            // Here, you would add code to create a Guest object and add it to your system
            JOptionPane.showMessageDialog(frame, "Guest Added: " + guestName + " - " + guestPhone);
        }
    }
    private static void deleteGuest(JFrame frame) {
        JTextField guestIDField = new JTextField(10);
        JPanel guestForm = new JPanel();
        guestForm.add(new JLabel("Guest ID:"));
        guestForm.add(guestIDField);
    
        int result = JOptionPane.showConfirmDialog(frame, guestForm, 
                "Enter Guest ID to Delete", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int guestID = Integer.parseInt(guestIDField.getText());
                // Assuming Hotel class has a method to remove a guest by ID
                boolean isDeleted = Hotel.removeGuest(guestID);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(frame, "Guest Deleted: ID " + guestID);
                } else {
                    JOptionPane.showMessageDialog(frame, "Guest Not Found: ID " + guestID);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid integer.");
            }
        }
    }
        private static void updateGuest(JFrame frame) {
            JTextField guestIDField = new JTextField(10);
            JTextField newNameField = new JTextField(10);
            JTextField newPhoneField = new JTextField(10);
    
            JPanel updateForm = new JPanel();
            updateForm.setLayout(new BoxLayout(updateForm, BoxLayout.Y_AXIS));
            updateForm.add(new JLabel("Guest ID:"));
            updateForm.add(guestIDField);
            updateForm.add(new JLabel("New Name:"));
            updateForm.add(newNameField);
            updateForm.add(new JLabel("New Phone:"));
            updateForm.add(newPhoneField);
    
            int result = JOptionPane.showConfirmDialog(frame, updateForm, 
                    "Enter Details to Update Guest", JOptionPane.OK_CANCEL_OPTION);
    
            if (result == JOptionPane.OK_OPTION) {
                try {
                    int guestID = Integer.parseInt(guestIDField.getText());
                    // The logic to find and update the guest should be implemented in your hotel management system
                    // For example: boolean success = Hotel.updateGuestDetails(guestID, newNameField.getText(), newPhoneField.getText());
                    // The following line is a placeholder for demonstration
                    boolean success = true; // Replace with actual call to update guest details
    
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Guest Updated: ID " + guestID);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Guest Not Found: ID " + guestID);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID format. Please enter a valid integer.");
                }
            }
        }
    
    private static void viewGuests(JFrame frame) {
        // Sample column names for the table
        String[] columnNames = {"Guest ID", "Name", "Phone Number"};
        
        // Sample data - you will replace this with real data from your Hotel management system
        Object[][] data = {
            {1, "John Doe", "1234567890"},
            {2, "Jane Smith", "0987654321"},
            // ... other guests
        };
    
        // Create a JTable with the sample data
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
    
        // Set up a panel to contain the table
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    
        // Display the panel in a dialog or in the main frame
        JDialog dialog = new JDialog(frame, "View Guests", true);
        dialog.add(panel);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private static void viewSalesReport(JFrame frame) {
        // Assuming you have a list of payment objects, replace Payment with your actual class name
        List<Payment> paymentList = Hotel.getAllPayments(); // Replace with your actual method to retrieve payments
    
        // Create column names for the sales report table
        String[] columnNames = {"Date", "Room Type", "Total Sales"};
    
        // Create a two-dimensional array to hold the sales report data
        Object[][] data = new Object[paymentList.size()][3];
    
        // Populate the data array with payment information
        for (int i = 0; i < paymentList.size(); i++) {
            Payment payment = paymentList.get(i);
            data[i][0] = payment.getType(); // Replace with the actual method to get the room type
            data[i][1] = Payment.getAmount(); // Replace with the actual method to get the total amount
        }
        // Create a JTable to display sales report data
        JTable salesTable = new JTable(data, columnNames);
        salesTable.setFillsViewportHeight(true);
    
        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(salesTable);
    
        // Create a panel to hold the table
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    
        // Create a dialog to display the sales report
        JDialog dialog = new JDialog(frame, "View Sales Report", true);
        dialog.add(panel);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private static void generateSalesReport(JFrame frame) {
        // Create column names for the sales report table
        String[] columnNames = {"Date", "Room Type", "Total Sales"};
    
        List<Payment> paymentList = new ArrayList<>(); // Initialize it with your payment data
        
        // Create a two-dimensional array to hold the sales report data
        Object[][] data = new Object[paymentList.size()][3];
    
        // Populate the data array with payment information
        for (int i = 0; i < paymentList.size(); i++) {
            Payment payment = paymentList.get(i);
            data[i][0] = payment.getType(); // Use the actual method to get the room type
            data[i][1] = payment.getAmount(); // Use the actual method to get the total amount
        }
    
        // Create a JTable to display the sales report data
        JTable salesTable = new JTable(data, columnNames);
        salesTable.setFillsViewportHeight(true);
    
        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(salesTable);
    
        // Create a panel to hold the table
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    
        // Create a dialog to display the sales report
        JDialog dialog = new JDialog(frame, "Generate Sales Report", true);
        dialog.add(panel);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
    public static void main(String[] args) {
        // Launch the Hotel Management System GUI.
        launchGUI();
    }
}

