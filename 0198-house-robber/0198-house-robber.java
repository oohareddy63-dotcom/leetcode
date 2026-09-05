class Solution {
    int rob(int[] nums) {
   // If there is only one house, rob it
    if (nums.length < 2)
        return nums[0];
    int[] dp = new int[nums.length];
    // First house
    dp[0] = nums[0];
    // Choose the house with more money among first two
    dp[1] = Math.max(nums[0], nums[1]);

    // Check every remaining house
    for (int i = 2; i < nums.length; i++) {

        // Option 1: Rob current house + money till i-2
        // Option 2: Skip current house
        // Take the better option
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }

    // Last cell contains the maximum money
    return dp[nums.length - 1];
}
}