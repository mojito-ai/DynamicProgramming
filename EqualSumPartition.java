public class EqualSumPartition {

    public static boolean solve(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        else
            return SubsetSum.solve(arr, sum % 2, arr.length);
    }

    public static void main(String args[]) {
        System.out.println(EqualSumPartition.solve(new int[] { 1, 5, 11, 5 }));
    }

}
