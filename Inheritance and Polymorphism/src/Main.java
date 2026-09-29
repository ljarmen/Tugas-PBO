public class Main {
    public static void main(String[] args) {
        // Demonstrating Inheritance and Polymorphism
        Animal animal = new Animal("Buddy");
        Cat cat = new Cat(4.5, "Milo");
        Bird bird = new Bird(0.8, "Tweety");
        Eagle eagle = new Eagle(500, 2.0, "Garuda");

        // Polymorphism: calling printInfo() on Animal type
        System.out.println("=== Polymorphism Demo ===");
        Animal[] animals = {animal, cat, bird, eagle};
        for (Animal a : animals) {
            a.printInfo();
        }

        // Details of each object
        System.out.println("\n=== Cat Details ===");
        System.out.println("Weight: " + cat.getWeight() + " kg");
        System.out.println("Food/day: " + cat.calculateFoodPerDay() + " kg");

        System.out.println("\n=== Bird Details ===");
        System.out.println("Wingspan: " + bird.getWingspan() + " m");
        System.out.println("Speed: " + bird.calculateSpeed() + " km/h");

        System.out.println("\n=== Eagle Details ===");
        System.out.println("Altitude: " + eagle.getAltitude() + " m");
        System.out.println("Wingspan: " + eagle.getWingspan() + " m");
        System.out.println("Dive Speed: " + eagle.calculateDiveSpeed() + " km/h");
    }
}
