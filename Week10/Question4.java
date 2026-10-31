package Week10;

import java.util.Arrays;

public class Question4 {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2)));
    }
}