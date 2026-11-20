package Week12;

import java.util.Scanner;

class StopNode {
    String data;
    StopNode next;

    StopNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Question1 {
    public static StopNode build(String[] stops) {
        if (stops == null || stops.length == 0) return null;
        StopNode head = new StopNode(stops[0]);
        StopNode tail = head;
        for (int i = 1; i < stops.length; i++) {
            tail.next = new StopNode(stops[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void printRoute(StopNode head) {
        if (head == null) return;
        StopNode curr = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            last = curr.data;
            count++;
            curr = curr.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        // Clean brackets if input is formatted like [Tambaram, Guindy, TNagar, Central]
        line = line.replace("[", "").replace("]", "");
        String[] parts = line.split(",");
        String[] stops = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            stops[i] = parts[i].trim();
        }

        StopNode head = build(stops);
        printRoute(head);
        sc.close();
    }
}