package LEETCODE.MaximumBeautyofanArrayAfterApplyingOperation;

import java.util.Arrays;

public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length == 1)
            return 1;
        int max = 1;
        int maxNum = 0;
        for (int n : nums) maxNum = Math.max(maxNum, n);
        int[] sum = new int[maxNum + 1];
        for (int n : nums) {
            sum[Math.max(0,n-k)]++;
            sum[Math.min(n+k+1,maxNum)]--;
        }
        int preFixSum =0;
        for (int i = 0 ;i<maxNum+1;i++) {
            preFixSum += sum[i];
            max = Math.max(max,preFixSum);
        }


        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumBeauty(new int[]{48,48,48,48}, 24);
        System.out.println("i = " + i);
    }
}
