package LEETCODE.NumberofWaystoSplitArray;

public class Solution {
    public int waysToSplitArray(int[] nums) {
        int answer = 0;
        int n = nums.length;
        long totalSum = 0;
        for(int i = 0; i < n;i++){
            totalSum+=nums[i];
        }

        long curSum = 0;
        for (int i = 0; i < n-1;i++ ){
            curSum += nums[i];
            if(curSum >= totalSum-curSum){
                answer++;
            }
        }
        return answer;
    }
}
