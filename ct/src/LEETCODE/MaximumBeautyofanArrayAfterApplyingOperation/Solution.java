package LEETCODE.MaximumBeautyofanArrayAfterApplyingOperation;

import java.util.Arrays;

public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1;
        int cntOfDup = 1;
        int pre = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i] - nums[pre] > 2*k){
                int j = pre+1;
                for (; j < i; j++){
                    if(nums[i] - nums[j] <= 2*k){
                        break;
                    }
                }
                pre = j;
                cntOfDup = i-j+1;
            }else{
                cntOfDup++;
                max = Math.max(max, cntOfDup);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumBeauty(new int[]{48,48,48,48}, 24);
        System.out.println("i = " + i);
    }
}
