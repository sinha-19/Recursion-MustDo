public class CountGoodNumbers {
    /*
     * Problem: Count number of good digit strings of length n.
     * Approach: Use fast exponentiation for even and odd positions.
     * Time Complexity: O(log N)
     * Space Complexity: O(log N)
     */
    static final int MOD = 1_000_000_007;
    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long evenPow = power(5, even);
        long oddPow = power(4, odd);
        return (int)((evenPow * oddPow) % MOD);
    }
    private static long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        long res = (half * half) % MOD;
        return (exp % 2 == 0) ? res : (res * base) % MOD;
    }
}
