public class countSubsetwithDiff {

    public static int count(int[] arr, int diff) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        return countSubsetsum.count(arr, (diff + sum) / 2);
    }

    public static void main(String args[]) {
        System.out.println(countSubsetwithDiff.count(new int[] { 1, 1, 2, 3 }, 1));
    }

}
