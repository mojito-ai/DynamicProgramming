class Knapsack {
    private int sum = 0;

    public static int solve(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= W)
            return Math.max(solve(wt, val, W - val[n - 1], n - 1), solve(wt, val, W, n - 1));
        else if (wt[n - 1] > W)
            return solve(wt, val, W, n - 1);

    }

}