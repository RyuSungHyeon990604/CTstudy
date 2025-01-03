public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
