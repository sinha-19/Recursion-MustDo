public class CheckSubsequenceSumK {
    /*
     * Problem: Check if there's a subsequence with sum equal to K.
     * Approach: Backtrack using recursion to check if any combination matches sum.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public static boolean existsSubsequence(int[] arr, int k) {
        return check(0, arr, k);
    }
    private static boolean check(int i, int[] arr, int sum) {
        if (i == arr.length) return sum == 0;
        return check(i + 1, arr, sum - arr[i]) || check(i + 1, arr, sum);
    }
}
