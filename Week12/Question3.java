package Week12;

import java.util.Scanner;

class BookNode {
    String data;
    BookNode next;

    BookNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Question3 {
    public static String find(BookNode head, String id) {
        int position = 1;
        int firstPos = -1;
        int copies = 0;

        BookNode curr = head;
        while (curr != null) {
            if (curr.data.equals(id)) {
                if (firstPos == -1) {
                    firstPos = position;
                }
                copies++;
            }
            position++;
            curr = curr.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPos + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // First line: e.g., B12 -> B07 -> B30 -> B07 -> B45 -> B07
        String chainInput = sc.nextLine().trim();
        String[] ids = chainInput.split("->");

        BookNode head = null;
        BookNode tail = null;
        for (String rawId : ids) {
            String trimmed = rawId.trim();
            if (trimmed.isEmpty() || trimmed.equals("null")) continue;
            BookNode node = new BookNode(trimmed);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // Second line: target book ID (e.g., B07)
        String targetId = sc.nextLine().trim();
        System.out.println(find(head, targetId));
        sc.close();
    }
}