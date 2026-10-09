package Week8;
import java.util.*;

abstract class Vehicle {
    abstract double calculate(int hours);
}

class Bike extends Vehicle {
    double calculate(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    double calculate(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    double calculate(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            if (type.equals("BIKE")) v = new Bike();
            else if (type.equals("CAR")) v = new Car();
            else v = new Truck();

            double charge = v.calculate(hours);
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}