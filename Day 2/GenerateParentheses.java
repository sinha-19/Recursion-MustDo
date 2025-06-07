import java.util.*;
public class GenerateParentheses {
    /*
     * Problem: Generate all combinations of valid parentheses of n pairs.
     * Approach: Recursively add '(' or ')' while maintaining valid state.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public static List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        generateUtil("", n, n, res);
        return res;
    }
    private static void generateUtil(String curr, int open, int close, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(curr);
            return;
        }
        if (open > 0) generateUtil(curr + "(", open - 1, close, res);
        if (close > open) generateUtil(curr + ")", open, close - 1, res);
    }
}
