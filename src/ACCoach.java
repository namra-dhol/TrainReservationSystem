class ACCoach extends Coach {
    private int acClass;

    public ACCoach(int acClass, int totalSeats) {
        super("AC " + acClass, totalSeats);
        this.acClass = acClass;
    }
}