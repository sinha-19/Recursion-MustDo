public class RecursiveAtoi {
    /*
     * Problem: Convert a string to integer using recursion.
     * Approach: Handle optional sign, then build the number recursively.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static int myAtoi(String s) {
        return helper(s.trim(), 0, 0, 1);
    }
    private static int helper(String s, int i, int result, int sign) {
        if (i >= s.length()) return sign * result;
        char c = s.charAt(i);
        if (i == 0 && (c == '-' || c == '+'))
            return helper(s, i + 1, result, c == '-' ? -1 : 1);
        if (!Character.isDigit(c)) return sign * result;
        int digit = c - '0';
        if (result > (Integer.MAX_VALUE - digit) / 10)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return helper(s, i + 1, result * 10 + digit, sign);
    }
}
