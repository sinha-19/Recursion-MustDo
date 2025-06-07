import java.util.*;
public class WordBreak {
    /*
     * Problem: Determine if string can be segmented into dictionary words
     * Approach: Recursively check all prefixes, memoize results to avoid recomputation
     * Time: O(N^3), N=length of string due to substring and memoization
     * Space: O(N) recursion stack + O(N) memo array
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(s, 0, dict, memo);
    }
    private boolean backtrack(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && backtrack(s, end, dict, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}
