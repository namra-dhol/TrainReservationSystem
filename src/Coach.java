import java.util.ArrayList;
import java.util.List;

abstract class Coach {
    protected String coachType;
    protected int totalSeats;
    protected int availableSeats;
    protected List<Integer> bookedSeats;

    public Coach(String coachType, int totalSeats) {
        this.coachType = coachType;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.bookedSeats = new ArrayList<>();
    }

    public boolean bookSeats(int count) {
        if (availableSeats >= count) {
            for (int i = 0; i < count; i++) {
                bookedSeats.add(totalSeats - availableSeats + 1);
                availableSeats--;
            }
            return true;
        }
        return false;
    }

    public int getAvailableSeats() { return availableSeats; }
    public String getCoachType() { return coachType; }
}
