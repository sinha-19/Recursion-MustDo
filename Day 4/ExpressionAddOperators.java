import java.util.*;
public class ExpressionAddOperators {
    /*
     * Problem: Add operators (+, -, *) between digits to match target value
     * Approach: Recursively try all splits and operators, track eval value and last multiplied for '*'
     * Time: O(4^N) exponential due to splits and operator choices
     * Space: O(N) recursion stack + output list
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, target, 0, 0, 0, "", res);
        return res;
    }
    private void helper(String num, int target, int pos, long eval, long multed, String expr, List<String> res) {
        if (pos == num.length()) {
            if (eval == target) res.add(expr);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break; // skip leading zeros
            String curStr = num.substring(pos, i + 1);
            long cur = Long.parseLong(curStr);
            if (pos == 0) {
                // First number, no operator
                helper(num, target, i + 1, cur, cur, curStr, res);
            } else {
                // '+'
                helper(num, target, i + 1, eval + cur, cur, expr + "+" + curStr, res);
                // '-'
                helper(num, target, i + 1, eval - cur, -cur, expr + "-" + curStr, res);
                // '*'
                helper(num, target, i + 1, eval - multed + multed * cur, multed * cur, expr + "*" + curStr, res);
            }
        }
    }
}
