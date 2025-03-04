import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private List<Train> trains = new ArrayList<>();
    private List<Ticket> bookedTickets = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void searchTrains(String source, String destination) {
        for (Train train : trains) {
            if (train.getDistance() > 0) {
                System.out.println("Train: " + train.getTrainNumber());
            }
        }
    }

    public Ticket bookTicket(int trainNumber, String coachType, int passengers) throws NoSeatsAvailableException {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                for (Coach coach : train.getCoaches()) {
                    if (coach.getCoachType().equals(coachType) && coach.getAvailableSeats() >= passengers) {
                        List<Integer> allocatedSeats = new ArrayList<>();
                        for (int i = 0; i < passengers; i++) {
                            allocatedSeats.add(i + 1);
                        }
                        int fare = train.getDistance() * passengers;
                        Ticket ticket = new Ticket(train, coachType, passengers, fare, allocatedSeats);
                        bookedTickets.add(ticket);
                        return ticket;
                    }
                }
            }
        }
        throw new NoSeatsAvailableException("No seats available for this class.");
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        // Adding trains
        List<Coach> coaches1 = new ArrayList<>();
        coaches1.add(new SleeperCoach(72));
        coaches1.add(new ACCoach(3, 48));
        Train train1 = new Train(17726, "Rajkot", "Mumbai", 750, coaches1);

        system.addTrain(train1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        System.out.print("Enter Coach Type: ");
        String coachType = scanner.next();
        System.out.print("Enter No. of Passengers: ");
        int passengers = scanner.nextInt();

        try {
            Ticket ticket = system.bookTicket(trainNumber, coachType, passengers);
            ticket.printTicket();
        } catch (NoSeatsAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
