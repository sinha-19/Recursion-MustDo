import java.util.*;
public class SubsetSum1 {
    /*
     * Problem: Compute all subset sums.
     * Approach: Recursively include/exclude and accumulate sums.
     * Time: O(2^N); Space: O(N)
     */
    public List<Integer> subsetSums(int[] arr) {
        List<Integer> res = new ArrayList<>();
        helper(arr, 0, 0, res);
        return res;
    }
    private void helper(int[] arr, int idx, int sum, List<Integer> res) {
        if (idx == arr.length) {
            res.add(sum);
            return;
        }
        helper(arr, idx + 1, sum + arr[idx], res);
        helper(arr, idx + 1, sum, res);
    }
}
