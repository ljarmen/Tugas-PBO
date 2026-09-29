public class Bird extends Animal {
    private double wingspan;

    public Bird(double wingspan, String name) {
        super(name);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double calculateSpeed() {
        return wingspan * 2.5;
    }

    @Override
    public void printInfo() {
        System.out.println("Bird named " + getName() + ", speed = " + calculateSpeed() + " km/h");
    }
}
