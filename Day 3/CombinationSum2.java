import java.util.*;
public class CombinationSum2 {
    /*
     * Problem: Unique combinations sum to target; no reuse, handle duplicates.
     * Approach: Backtracking with recursion + skip duplicates.
     * Time: O(2^N); Space: O(N)
     */
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
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
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            curr.add(arr[i]);
            helper(arr, i + 1, target - arr[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
