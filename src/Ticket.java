import java.util.List;

public class Ticket {
    private static int nextPNR = 100000001;
    private int PNR;
    private Train train;
    private String coachType;
    private int passengerCount;
    private int totalFare;
    private List<Integer> allocatedSeats;

    public Ticket(Train train, String coachType, int passengerCount, int totalFare, List<Integer> allocatedSeats) {
        this.PNR = nextPNR++;
        this.train = train;
        this.coachType = coachType;
        this.passengerCount = passengerCount;
        this.totalFare = totalFare;
        this.allocatedSeats = allocatedSeats;
    }

    public void printTicket() {
        System.out.println("PNR: " + PNR);
        System.out.println("Train: " + train.getTrainNumber());
        System.out.println("Coach: " + coachType);
        System.out.println("Passengers: " + passengerCount);
        System.out.println("Total Fare: " + totalFare);
        System.out.println("Seats Allocated: " + allocatedSeats);
    }
}
