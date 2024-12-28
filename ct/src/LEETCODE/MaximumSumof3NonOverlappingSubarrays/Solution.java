package LEETCODE.MaximumSumof3NonOverlappingSubarrays;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n-k+1];
        for(int i = 0 ;i<k;i++){
            dp[0] += nums[i];
        }
        for(int i = 1; i <= n-k;i++){
            dp[i] = dp[i-1] +nums[i+k-1]-nums[i-1];
        }
        int[][] dp2 = new int[n-k+1][4];
        int[][] dp3 = new int[n-k+1][4];
        for(int i = 0;i<n-k+1;i++){
            for (int j = 1 ;j < 4 ;j++){
                if(i >= k){
                    if(dp2[i-1][j] >= dp[i] + dp2[i-k][j-1]){
                        dp2[i][j] = dp2[i-1][j];
                        dp3[i][j] = dp3[i-1][j];
                    }else{
                        dp2[i][j] = dp[i] + dp2[i-k][j-1];
                        dp3[i][j] = i;
                    }
                }else{
                    if(i>0){
                        if(dp2[i-1][j] >= dp[i]){
                            dp2[i][j] = dp2[i-1][j];
                            dp3[i][j] = dp3[i-1][j];
                        }else{
                            dp2[i][j] = dp[i];
                            dp3[i][j] = i;
                        }
                    }else{
                        dp2[i][j] = dp[i];
                        dp3[i][j] = i;
                    }


                }
            }
        }
        int[] result = new int[3];
        int current = n - k;
        for (int j = 3; j >= 1; j--) {
            result[j - 1] = dp3[current][j];
            current = result[j - 1] - k;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSumOfThreeSubarrays(new int[]{1,2,1,2,1,2,1,2,1}, 2);
    }
}
