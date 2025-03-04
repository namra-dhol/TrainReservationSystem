import java.util.List;

public class Train {
    private int trainNumber;
    private String source;
    private String destination;
    private int distance;
    private List<Coach> coaches;

    public Train(int trainNumber, String source, String destination, int distance, List<Coach> coaches) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.coaches = coaches;
    }

    public int getTrainNumber() { return trainNumber; }
    public int getDistance() { return distance; }
    public List<Coach> getCoaches() { return coaches; }
}
