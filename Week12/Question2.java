package Week12;

import java.util.Scanner;

class LineNode {
    String data;
    LineNode next;

    LineNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Question2 {
    public static LineNode addFirst(LineNode head, String name) {
        LineNode newNode = new LineNode(name);
        newNode.next = head;
        return newNode;
    }

    public static LineNode addLast(LineNode head, String name) {
        LineNode newNode = new LineNode(name);
        if (head == null) {
            return newNode;
        }
        LineNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public static void printLine(LineNode head) {
        LineNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LineNode head = null;

        // First line: initial chain (e.g., "Asha -> Ravi" or "(empty)")
        String initial = sc.nextLine().trim();
        if (!initial.isEmpty() && !initial.equalsIgnoreCase("(empty)") && !initial.equalsIgnoreCase("empty")) {
            String[] names = initial.split("->");
            for (String n : names) {
                String trimmed = n.trim();
                if (!trimmed.isEmpty() && !trimmed.equals("null")) {
                    head = addLast(head, trimmed);
                }
            }
        }

        // Second line: operations (e.g., "addFirst(Neha), addLast(Kiran), addFirst(Mohan)")
        String opsLine = sc.nextLine().trim();
        String[] ops = opsLine.split(",");
        for (String op : ops) {
            op = op.trim();
            if (op.startsWith("addFirst")) {
                String name = op.substring(op.indexOf('(') + 1, op.indexOf(')')).trim();
                head = addFirst(head, name);
            } else if (op.startsWith("addLast")) {
                String name = op.substring(op.indexOf('(') + 1, op.indexOf(')')).trim();
                head = addLast(head, name);
            }
        }

        printLine(head);
        sc.close();
    }
}