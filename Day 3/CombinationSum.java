import java.util.*;
public class CombinationSum {
    /*
     * Problem: Combinations sum to target; can reuse numbers.
     * Approach: Recursive backtracking with include/exclude.
     * Time: O(2^T * K); Space: O(K)
     */
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, 0, target, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] arr, int idx, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (idx == arr.length || target < 0) return;
        // Include
        curr.add(arr[idx]);
        helper(arr, idx, target - arr[idx], curr, res);
        curr.remove(curr.size() - 1);
        // Exclude
        helper(arr, idx + 1, target, curr, res);
    }
}
