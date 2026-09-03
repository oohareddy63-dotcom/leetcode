class Solution {
    public double myPow(double x, int n) {
        // Use a long to avoid overflow when converting Integer.MIN_VALUE to positive
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
   private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        // 1. Correctly store the result as a double
        double half = fastPow(x, n / 2);   
        // 2. Square it without redeclaring the same variable name
        double halfSq = half * half;
        // 3. If the power is odd, multiply by the base 'x' one more time
        if (n % 2 != 0) {
            return x * halfSq;
        }
        return halfSq;
    }
}