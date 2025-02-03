package LEETCODE.LongestStrictlyIncreasingorStrictlyDecreasingSubarray;

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int decreasing = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing++;
                decreasing = 1;
            }else if (nums[i] < nums[i - 1]) {
                increasing = 1;
                decreasing++;
            } else {
                increasing = 1;
                decreasing = 1;
            }
            max =  Math.max(decreasing,Math.max(max, increasing));
        }

        return max;
    }
}
