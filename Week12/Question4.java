package Week12;

import java.util.Scanner;

class BookingNode {
    String data;
    BookingNode next;

    BookingNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Question4 {
    public static BookingNode removeFirst(BookingNode head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        // Case 1: Match is at the head
        if (head.data.equals(booking)) {
            return head.next;
        }

        // Case 2: Search for the node just before the match
        BookingNode curr = head;
        while (curr.next != null && !curr.next.data.equals(booking)) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        } else {
            System.out.println(booking + " not found");
        }
        return head;
    }

    public static void printChain(BookingNode head) {
        BookingNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // First line: e.g., 104 -> 101 -> 107 -> 101
        String chainInput = sc.nextLine().trim();
        BookingNode head = null;
        BookingNode tail = null;

        if (!chainInput.isEmpty() && !chainInput.equalsIgnoreCase("(empty)")) {
            String[] bookings = chainInput.split("->");
            for (String b : bookings) {
                String trimmed = b.trim();
                if (trimmed.isEmpty() || trimmed.equals("null")) continue;
                BookingNode node = new BookingNode(trimmed);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }

        // Second line: booking number to cancel (e.g., 101)
        String cancelId = sc.nextLine().trim();
        head = removeFirst(head, cancelId);
        printChain(head);
        sc.close();
    }
}