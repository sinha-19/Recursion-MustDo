import java.util.*;
public class SubsetSum2 {
    /*
     * Problem: All unique subsets including duplicates.
     * Approach: Sort + recursive backtracking + skip duplicates.
     * Time: O(2^N); Space: O(N)
     */
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, 0, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] arr, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            curr.add(arr[i]);
            helper(arr, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
