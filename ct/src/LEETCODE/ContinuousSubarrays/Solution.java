package LEETCODE.ContinuousSubarrays;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0,right = 0;
        long cnt =0;
        int min = nums[0];
        int max = nums[0];
        for ( right =0; right < nums.length; right++) {
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);
            if(max - min > 2){
                long len = right - left;
                cnt += (len*(len+1))/2;
                left = right;
                min = nums[right];
                max = nums[right];
                while(left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2){
                    left--;
                    max = Math.max(max, nums[left]);
                    min = Math.min(min, nums[left]);
                }
                if (left < right) {
                    len = right - left;
                    cnt -= (len * (len + 1)) / 2;
                }
            }
        }
        long len = right - left;
        cnt += (len*(len+1))/2;

        return cnt;
    }
}
