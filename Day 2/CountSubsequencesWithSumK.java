public class CountSubsequencesWithSumK {
    /*
     * Problem: Count all subsequences in array that sum up to K.
     * Approach: Recursively explore pick/not-pick options.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public static int count(int[] arr, int k) {
        return helper(0, arr, k);
    }
    private static int helper(int idx, int[] arr, int sum) {
        if (idx == arr.length) return sum == 0 ? 1 : 0;
        int pick = helper(idx + 1, arr, sum - arr[idx]);
        int notPick = helper(idx + 1, arr, sum);
        return pick + notPick;
    }
}
