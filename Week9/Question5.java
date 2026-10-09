package Week9;

import java.util.*;

abstract class Appliance {
    abstract double power();

    double units(double hours) {
        return power() * hours / 1000;
    }

    double cost(double units) {
        return units * 8;
    }
}

interface SaverMode {
    double save(double units);
}

class Fridge extends Appliance {
    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    double power() { return 1500; }
    public double save(double units) { return units * 0.75; }
}

class TV extends Appliance {
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    double power() { return 500; }
    public double save(double units) { return units * 0.75; }
}

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER") && sc.next().equals("SAVER");
            Appliance a;

            if (type.equals("FRIDGE")) a = new Fridge();
            else if (type.equals("AC")) a = new AC();
            else if (type.equals("TV")) a = new TV();
            else a = new Washer();

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units(hours);
            if (saver) units = ((SaverMode) a).save(units);

            double cost = a.cost(units);
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}