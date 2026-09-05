public class Question4 {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int n : row)
            sum += n;

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {

            if (i > 0) result += " | ";

            if (rowAverage(runsPerOver[i]) >= threshold)
                result += "Match " + i + ": Power Surge";
            else
                result += "Match " + i + ": Normal";
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runs, 8));
    }
}