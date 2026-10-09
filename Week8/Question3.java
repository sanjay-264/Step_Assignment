package Week8;
import java.util.*;

abstract class Room {
    abstract double calculate(int units);
}

class SingleRoom extends Room {
    double calculate(int units) {
        return units * 8;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    double calculate(int units) {
        return units * 6.0 / occupants;
    }
}

class ACRoom extends Room {
    double calculate(int units) {
        return units * 10 + 200;
    }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            if (type.equals("SINGLE")) r = new SingleRoom();
            else if (type.equals("SHARED")) r = new SharedRoom(sc.nextInt());
            else r = new ACRoom();

            double bill = r.calculate(units);
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}