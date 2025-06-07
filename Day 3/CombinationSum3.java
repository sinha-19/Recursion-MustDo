import java.util.*;
public class CombinationSum3 {
    /*
     * Problem: Buy k numbers from 1–9 that sum to n, no reuse.
     * Approach: Recursive combination with start and count.
     * Time: O(2^9); Space: O(k)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), res);
        return res;
    }
    private void helper(int start, int k, int target, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0 && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || curr.size() >= k) return;
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            helper(i + 1, k, target - i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
