public class GenerateAllBinaryStrings {
    /*
     * Problem: Generate all binary strings of length n without consecutive 1s.
     * Approach: Recursive backtracking – choose '0' freely, choose '1' only after '0'.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public static void generate(int n) {
        helper(n, "", '0');
    }
    private static void helper(int n, String curr, char prev) {
        if (n == 0) {
            System.out.println(curr);
            return;
        }
        helper(n - 1, curr + "0", '0');
        if (prev == '0') {
            helper(n - 1, curr + "1", '1');
        }
    }
}
