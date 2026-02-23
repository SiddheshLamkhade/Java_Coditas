package HMS;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HMS_CLI {
    public static void main(String[] args) {
        GuestManager guestManager = new GuestManager();
        RoomManager roomManager = new RoomManager();
        ReservationManager reservationManager = new ReservationManager(guestManager, roomManager);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add Guest");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Rooms");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
            try {
                switch (option) {
                    case "1":
                        System.out.print("Enter Guest ID: ");
                        String guestId = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Contact Details: ");
                        String contact = scanner.nextLine();
                        guestManager.addGuest(new Guest(guestId, name, contact));
                        System.out.println("Guest added successfully.");
                        break;
                    case "2":
                        System.out.print("Enter Guest ID: ");
                        String gId = scanner.nextLine();
                        System.out.print("Enter Reservation Type (Room/EventHall/Spa): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter Reservation Date (yyyy-MM-dd): ");
                        String dateStr = scanner.nextLine();
                        Date date = sdf.parse(dateStr);
                        String resId = "RES" + System.currentTimeMillis();
                        if (type.equalsIgnoreCase("Room")) {
                            System.out.print("Enter Room ID: ");
                            String roomId = scanner.nextLine();
                            reservationManager.makeRoomReservation(resId, gId, date, roomId);
                        } else if (type.equalsIgnoreCase("EventHall")) {
                            System.out.print("Enter Hall ID: ");
                            String hallId = scanner.nextLine();
                            reservationManager.makeEventHallReservation(resId, gId, date, hallId);
                        } else if (type.equalsIgnoreCase("Spa")) {
                            System.out.print("Enter Spa ID: ");
                            String spaId = scanner.nextLine();
                            reservationManager.makeSpaReservation(resId, gId, date, spaId);
                        } else {
                            System.out.println("Invalid reservation type.");
                        }
                        System.out.println("Reservation made successfully.");
                        break;
                    case "3":
                        roomManager.viewRooms();
                        break;
                    case "4":
                        System.out.print("Enter Reservation ID to cancel: ");
                        String cancelId = scanner.nextLine();
                        reservationManager.cancelReservation(cancelId);
                        System.out.println("Reservation cancelled successfully.");
                        break;
                    case "5":
                        running = false;
                        System.out.println("Exiting HMS. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InvalidGuestException | InvalidReservationException | GuestNotFoundException | RoomNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}


