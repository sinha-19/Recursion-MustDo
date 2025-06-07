import java.util.*;
public class LetterCombinationsPhone {
    /*
     * Problem: All letter combos for a phone number string.
     * Approach: Map digits to letters; recursively build combinations.
     * Time: O(4^N); Space: O(N)
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, new StringBuilder(), map, res);
        return res;
    }
    private void helper(String digits, int idx, StringBuilder curr, String[] map, List<String> res) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            curr.append(c);
            helper(digits, idx + 1, curr, map, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
