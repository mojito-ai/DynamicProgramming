public class SubsetSum {

    public static boolean solve(int wt[], int sum, int n) {
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

        // for (int i = 0; i < t.length; i++) {
        // for (int j = 0; j < t[0].length; j++) {
        // System.out.print(t[i][j] + " ");
        // }
        // System.out.println();
        // }

        return t[n][sum];

    }

    public static void main(String args[]) {
        System.out.println(SubsetSum.solve(new int[] { 2, 3, 7, 8, 10 }, 11, 5));
    }

}
