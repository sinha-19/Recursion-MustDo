public class PrintAllSubsequences {
    /*
     * Problem: Print all subsequences of a string.
     * Approach: Recursively include or exclude each character.
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public static void print(String s) {
        solve(s, 0, "");
    }
    private static void solve(String s, int idx, String curr) {
        if (idx == s.length()) {
            System.out.println(curr);
            return;
        }
        solve(s, idx + 1, curr + s.charAt(idx));
        solve(s, idx + 1, curr);
    }
}
