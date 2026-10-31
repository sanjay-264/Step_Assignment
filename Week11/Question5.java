package Week11;

public class Question5 {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls)
            count[roll]++;

        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + " ");

        System.out.println();

        int[] result = new int[rolls.length];
        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                result[index++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};

        int[] result = diceSort(rolls);

        System.out.println("Sorted: " + java.util.Arrays.toString(result));
    }
}
