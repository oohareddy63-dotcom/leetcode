class Solution {
    public int climbStairs(int n) {
      
        int dp[] = new int[n + 1];
        
        // Base case: 1 way to stay at 0th stair (do nothing)
        dp[0] = 1;

        // Tabulation loop
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    
    }
}