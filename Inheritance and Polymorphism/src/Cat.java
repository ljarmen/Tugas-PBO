public class Cat extends Animal {
    private double weight;

    public Cat(double weight, String name) {
        super(name);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateFoodPerDay() {
        return weight * 0.03;
    }

    @Override
    public void printInfo() {
        System.out.println("Cat named " + getName() + ", food/day = " + calculateFoodPerDay() + " kg");
    }
}
