import java.util.*;

public class TrainReservationSystem {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding predefined trains
        List<Coach> train1Coaches = new ArrayList<>();
        train1Coaches.add(new SleeperCoach(72));
        train1Coaches.add(new SleeperCoach(72));
        train1Coaches.add(new ACCoach(3, 72));
        train1Coaches.add(new ACCoach(2, 48));
        train1Coaches.add(new ACCoach(1, 24));
        Train train1 = new Train(17726, "Rajkot", "Mumbai", 750, train1Coaches);

        List<Coach> train2Coaches = new ArrayList<>();
        train2Coaches.add(new SleeperCoach(15));
        train2Coaches.add(new SleeperCoach(20));
        train2Coaches.add(new SleeperCoach(50));
        train2Coaches.add(new ACCoach(3, 36));
        train2Coaches.add(new ACCoach(3, 48));
        Train train2 = new Train(17728, "Rajkot", "Mumbai", 750, train2Coaches);

        system.addTrain(train1);
        system.addTrain(train2);

        while (true) {
            System.out.println("\n=== Train Reservation System ===");
            System.out.println("1. Search Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Search Trains
                    System.out.print("Enter Starting Point: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    system.searchTrains(source, destination);
                    break;

                case 2:
                    // Book Ticket
                    System.out.print("Enter Train Number: ");
                    int trainNumber = scanner.nextInt();
                    System.out.print("Enter Class (S/B/A/H): ");
                    String coachType = scanner.next();
                    System.out.print("Enter Number of Passengers: ");
                    int passengers = scanner.nextInt();

                    try {
                        Ticket ticket = system.bookTicket(trainNumber, coachType, passengers);
                        ticket.printTicket();
                        System.out.print("Confirm Booking? (Yes/No): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("Yes")) {
                            System.out.println("Ticket Booked Successfully!");
                        } else {
                            System.out.println("Booking Canceled.");
                        }
                    } catch (NoSeatsAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Thank you for using the Train Reservation System!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
