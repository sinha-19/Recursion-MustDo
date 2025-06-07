public class PowerXN {
    /*
     * Problem: Compute x^n using recursion.
     * Approach: Fast exponentiation (divide and conquer).
     * Time Complexity: O(log N)
     * Space Complexity: O(log N)
     */
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
    private static double power(double x, long n) {
        if (n == 0) return 1.0;
        double half = power(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }
}
