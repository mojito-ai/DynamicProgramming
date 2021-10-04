public class KnapsackTopDown {

    public static int solve(int wt[], int val[], int W, int n) {
        int t[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++)
                if (i == 0 || j == 0)
                    t[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j)
                    t[i][j] = Math.max((val[i - 1] + t[i - 1][j - wt[i - 1]]), t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][W];
    }

    public static void main(String[] args) {

        System.out.println(solve(new int[] { 1, 3, 4, 5, 11 }, new int[] { 1, 4, 5, 7, 12 }, 17, 5));
    }

}
