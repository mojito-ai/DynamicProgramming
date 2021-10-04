public class minSubsetSumDiff {

    public static int solve(int arr[]) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        boolean temp[] = subsetsum(arr, sum);

        int mn = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (temp[i] == true)
                mn = Math.min(mn, sum - 2 * i);
        }

        return mn;
    }

    private static boolean[] subsetsum(int wt[], int sum) {
        int n = wt.length;

        boolean t[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= sum; j++) {

                if (wt[i - 1] <= j)
                    t[i][j] = t[i - 1][j - wt[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        boolean v[] = new boolean[sum + 1];
        for (int i = 0; i < sum + 1; i++)
            v[i] = t[n][i];

        return v;
    }

    public static void main(String args[]) {
        System.out.println(minSubsetSumDiff.solve(new int[] { 1, 6, 11, 5 }));
    }
}