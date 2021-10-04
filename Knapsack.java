
class Knapsack {

    private int t[][];

    Knapsack(int W, int n) {
        t = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++)
                t[i][j] = -1;
    }

    public int solve(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (t[n][W] != -1)
            return t[n][W];

        if (wt[n - 1] <= W)
            return t[n][W] = Math.max(val[n - 1] + solve(wt, val, W - wt[n - 1], n - 1), solve(wt, val, W, n - 1));

        else
            return t[n][W] = solve(wt, val, W, n - 1);

    }

    public void show() {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack(17, 5);

        System.out.println(ks.solve(new int[] { 1, 3, 4, 5, 11 }, new int[] { 1, 4, 5, 7, 12 }, 17, 5));
        System.out.println();
    }

}