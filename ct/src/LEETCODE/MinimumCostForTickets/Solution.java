package LEETCODE.MinimumCostForTickets;


public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if(i != days[index]){
               dp[i] = dp[i-1];
            }else{
                index++;
                int cost1 = dp[i-1] + costs[0];
                int cost7 = costs[1];
                int cost30 = costs[2];
                if(i-7>=0){
                    cost7 = dp[i-7] + costs[1];
                }
                if(i-30>=0){
                    cost30 = dp[i-30] + costs[2];
                }
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }


        }

        return dp[days[n-1]];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mincostTickets(new int[]{1},new int[]{3,2,1});
    }
}
