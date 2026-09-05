import java.util.Arrays;

public class Question5 implements Comparable<Question5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Question5(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(Question5 other) {
        return Double.compare(other.battingAverage, battingAverage);
    }

    static String draftAndRank(Question5[] players) {

        Question5[] draftable = new Question5[players.length];
        int count = 0;

        for (Question5 player : players) {
            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count++] = player;
            }
        }

        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result += " | ";
            result += (i + 1) + ". " + draftable[i].name;
        }

        return result;
    }

    public static void main(String[] args) {

        Question5[] players = {
            new Question5("Virat", 15, 48.0, false),
            new Question5("Rahul", 7, 55.0, false),
            new Question5("Sameer", 3, 60.0, false),
            new Question5("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}