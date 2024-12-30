package LEETCODE.CountWaysToBuildGoodStrings;

import java.util.Arrays;

public class Solution {
    private int MOD = 1000000007;
    private int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return  dfs(zero,one,low,high,0);
    }

    private int dfs(int zero,int one,int low,int high,int sum){
        if(sum > high) return 0;
        if(sum == high){
            return 1;
        }
        if(dp[sum] != -1){
            return dp[sum];
        }
        dp[sum] = 0;
        if(sum >= low){
            dp[sum]++;
        }
        dp[sum] = (dp[sum] + dfs(zero,one,low,high,sum+zero)) % MOD;
        dp[sum] = (dp[sum] + dfs(zero,one,low,high,sum+one)) % MOD;

        return dp[sum];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countGoodStrings(3,3,1,1);
    }
}
