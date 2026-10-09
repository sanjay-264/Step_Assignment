package Week8;

import java.util.*;
import java.time.*;

abstract class Plan {
    abstract int validity();
}

class Basic extends Plan {
    int validity() {
        return 30;
    }
}

class Standard extends Plan {
    int validity() {
        return 90;
    }
}

class Premium extends Plan {
    int validity() {
        return 365;
    }
}

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan p;

            if (type.equals("BASIC")) p = new Basic();
            else if (type.equals("STANDARD")) p = new Standard();
            else p = new Premium();

            System.out.println(name + ": " + date.plusDays(p.validity()));
        }
    }
}