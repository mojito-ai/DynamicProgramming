class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int i = 0; i < nums.length; i++)
            s += nums[i];

        return countsubsetsum(nums, (s + target) / 2);

    }

    private static int countsubsetsum(int arr[], int sum) {
        int n = arr.length;
        int t[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];

                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][sum];
    }

    public static void main(String args[]) {
        System.out.println(TargetSum.findTargetSumWays(new int[] { 1, 1, 2, 3 }, 1));
    }
}