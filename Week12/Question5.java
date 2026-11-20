package Week12;

import java.util.Scanner;

class PlateNode {
    String data;
    PlateNode next;

    PlateNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class PlateStack {
    private PlateNode head;
    private int size;

    public PlateStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(String plate) {
        PlateNode newNode = new PlateNode(plate);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("push " + plate + " -> top " + head.data + ", size " + size);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }
        String popped = head.data;
        head = head.next;
        size--;
        System.out.println("pop -> " + popped + ", size " + size);
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return;
        }
        System.out.println("peek -> " + head.data);
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateStack stack = new PlateStack();

        // Reads comma-separated operations (can span multiple lines if pasted)
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            sb.append(line).append(",");
        }

        String[] ops = sb.toString().split(",");
        for (String rawOp : ops) {
            String op = rawOp.trim();
            if (op.isEmpty()) continue;

            if (op.startsWith("push")) {
                String plate = op.substring(op.indexOf('(') + 1, op.indexOf(')')).trim();
                stack.push(plate);
            } else if (op.startsWith("pop")) {
                stack.pop();
            } else if (op.startsWith("peek")) {
                stack.peek();
            } else if (op.startsWith("isEmpty")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }
        sc.close();
    }
}