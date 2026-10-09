package Week9;

import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double transport() { return 12000; }

    double totalFee() {
        return tuition() + (this instanceof BusUser ? transport() : 0);
    }
}

interface BusUser {}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 100000; }
}

class Scholar extends Student implements BusUser {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next(), name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR")) s = new DayScholar(name);
            else if (type.equals("HOSTELLER")) s = new Hosteller(name);
            else s = new Scholar(name);

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}