Name: Henriko Almer Rayyan

NIM: (F1D02410050)


# Inheritance and Polymorphism

A Java program demonstrating the concepts of **Encapsulation**, **Inheritance**, and **Polymorphism** using an animal class hierarchy.

## Class Structure

```
Animal (superclass)
├── Cat extends Animal
├── Bird extends Animal
│   └── Eagle extends Bird
```

| Class | File | Description |
|-------|------|-------------|
| `Animal` | `src/Animal.java` | Base class with `name` attribute |
| `Cat` | `src/Cat.java` | Cat, derived from `Animal` |
| `Bird` | `src/Bird.java` | Bird, derived from `Animal` |
| `Eagle` | `src/Eagle.java` | Eagle, derived from `Bird` |
| `Main` | `src/Main.java` | Main class to run the program |

---

## 1. Encapsulation

Encapsulation is the concept of hiding the internal details of an object and only providing access through public methods (getters/setters).

### Examples in code:

- **`Cat.java`** — the `weight` attribute is declared `private`, and can only be accessed through `getWeight()` and `setWeight()`:
  ```java
  private double weight;          // hidden from outside the class

  public double getWeight() {     // getter to access weight value
      return weight;
  }

  public void setWeight(double weight) {  // setter to modify weight value
      this.weight = weight;
  }
  ```

- **`Bird.java`** — the `wingspan` attribute is declared `private`, accessed via `getWingspan()` and `setWingspan()`:
  ```java
  private double wingspan;

  public double getWingspan() { return wingspan; }
  public void setWingspan(double wingspan) { this.wingspan = wingspan; }
  ```

- **`Eagle.java`** — the `altitude` attribute is declared `private`, accessed via `getAltitude()` and `setAltitude()`:
  ```java
  private double altitude;

  public double getAltitude() { return altitude; }
  public void setAltitude(double altitude) { this.altitude = altitude; }
  ```

With encapsulation, the internal data of objects is protected and can only be modified through defined methods.

---

## 2. Inheritance

Inheritance is the concept where a class (subclass) inherits attributes and methods from another class (superclass) using the `extends` keyword.

### Examples in code:

- **`Cat extends Animal`** — inherits the `name` attribute as well as the `getName()` and `setName()` methods from the `Animal` class:
  ```java
  public class Cat extends Animal {
      public Cat(double weight, String name) {
          super(name);  // calls the superclass Animal's constructor
          this.weight = weight;
      }
  }
  ```

- **`Bird extends Animal`** — also inherits attributes and methods from `Animal`:
  ```java
  public class Bird extends Animal {
      public Bird(double wingspan, String name) {
          super(name);  // calls the superclass Animal's constructor
          this.wingspan = wingspan;
      }
  }
  ```

- **`Eagle extends Bird`** — inherits from `Bird`, which means it also inherits from `Animal` (multi-level inheritance). The Eagle can use `getWingspan()`, `getName()`, and `calculateSpeed()` from its parent classes:
  ```java
  public class Eagle extends Bird {
      public Eagle(double altitude, double wingspan, String name) {
          super(wingspan, name);  // calls the Bird's constructor
          this.altitude = altitude;
      }

      public double calculateDiveSpeed() {
          return calculateSpeed() + altitude * 0.5;  // uses calculateSpeed() from Bird
      }
  }
  ```

---

## 3. Polymorphism

Polymorphism is the concept where the same method (`printInfo()`) has different behaviors depending on the object that calls it. This is achieved with **method overriding** (`@Override`).

### Examples in code:

Each subclass overrides the `printInfo()` method from the `Animal` class:

| Class | Output `printInfo()` |
|-------|---------------------|
| `Animal` | `"Animal named [name]"` |
| `Cat` | `"Cat named [name], food/day = [food] kg"` |
| `Bird` | `"Bird named [name], speed = [speed] km/h"` |
| `Eagle` | `"Eagle named [name], dive speed = [diveSpeed] km/h"` |

In **`Main.java`**, polymorphism is demonstrated by storing all objects in an array of type `Animal` and calling `printInfo()` — Java automatically executes the method version corresponding to the actual object type:

```java
Animal[] animals = {animal, cat, bird, eagle};
for (Animal a : animals) {
    a.printInfo();  // the called method depends on the actual object type
}
```

---

## Output

```
=== Polymorphism Demo ===
Animal named Buddy
Cat named Milo, food/day = 0.135 kg
Bird named Tweety, speed = 2.0 km/h
Eagle named Garuda, dive speed = 255.0 km/h

=== Cat Details ===
Weight: 4.5 kg
Food/day: 0.135 kg

=== Bird Details ===
Wingspan: 0.8 m
Speed: 2.0 km/h

=== Eagle Details ===
Altitude: 500.0 m
Wingspan: 2.0 m
Dive Speed: 255.0 km/h
```

Even though the variable `a` is of type `Animal`, the executed `printInfo()` method belongs to each subclass respectively — this is **runtime polymorphism**.

---



# Tugas-PBO