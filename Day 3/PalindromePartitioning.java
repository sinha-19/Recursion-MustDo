import java.util.*;
public class PalindromePartitioning {
    /*
     * Problem: Partition string into palindromic substrings.
     * Approach: Recursively partition and backtrack on palindrome check.
     * Time: O(2^N); Space: O(N)
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void helper(String s, int idx, List<String> curr, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int end = idx + 1; end <= s.length(); end++) {
            String sub = s.substring(idx, end);
            if (isPalindrome(sub)) {
                curr.add(sub);
                helper(s, end, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) if (str.charAt(l++) != str.charAt(r--)) return false;
        return true;
    }
}
