package Week10;

public class Question3 {

    static int[] busiestRow(int[][] grid) {
        int max = -1;
        int rowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > max) {
                max = total;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, max};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);

        System.out.println("Row: " + result[0]);
        System.out.println("Total: " + result[1]);
    }
}