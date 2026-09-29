public class Eagle extends Bird {
    private double altitude;

    public Eagle(double altitude, double wingspan, String name) {
        super(wingspan, name);
        this.altitude = altitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double calculateDiveSpeed() {
        return calculateSpeed() + altitude * 0.5;
    }

    @Override
    public void printInfo() {
        System.out.println("Eagle named " + getName() + ", dive speed = " + calculateDiveSpeed() + " km/h");
    }
}
