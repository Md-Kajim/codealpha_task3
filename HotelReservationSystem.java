import java.util.*;

// HotelRoom class to store room details
class HotelRoom {
    String roomNumber;
    String category; // Standard, Deluxe, Suite
    boolean isBooked;

    HotelRoom(String roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

// Reservation System
class ReservationSystem {
    private List<HotelRoom> rooms = new ArrayList<>();

    // Add room
    void addRoom(String roomNumber, String category) {
        rooms.add(new HotelRoom(roomNumber, category));
    }

    // Search available rooms
    void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (HotelRoom room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - " + room.category);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available at the moment.");
        }
    }

    // Book room
    void bookRoom(String roomNumber) {
        for (HotelRoom room : rooms) {
            if (room.roomNumber.equals(roomNumber) && !room.isBooked) {
                room.isBooked = true;
                System.out.println("Room " + room.roomNumber + " has been booked successfully.");
                return;
            }
        }
        System.out.println("Room not available for booking.");
    }

    // Cancel booking
    void cancelBooking(String roomNumber) {
        for (HotelRoom room : rooms) {
            if (room.roomNumber.equals(roomNumber) && room.isBooked) {
                room.isBooked = false;
                System.out.println("Booking for Room " + room.roomNumber + " has been cancelled.");
                return;
            }
        }
        System.out.println("Room not found or not booked.");
    }
}

// Main class
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        // Pre-adding some rooms
        system.addRoom("101", "Standard");
        system.addRoom("102", "Deluxe");
        system.addRoom("103", "Suite");
        system.addRoom("104", "Standard");

        while (true) {
            System.out.println("\n=== Hotel Reservation Menu ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                system.searchAvailableRooms();
            } else if (choice == 2) {
                System.out.print("Enter Room Number to Book: ");
                String roomNumber = sc.next();
                system.bookRoom(roomNumber);
            } else if (choice == 3) {
                System.out.print("Enter Room Number to Cancel: ");
                String roomNumber = sc.next();
                system.cancelBooking(roomNumber);
            } else if (choice == 4) {
                System.out.println("Thank you for using the Hotel Reservation System!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}