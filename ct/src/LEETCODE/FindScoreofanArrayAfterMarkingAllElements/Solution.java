package LEETCODE.FindScoreofanArrayAfterMarkingAllElements;

import java.util.*;

public class Solution {
    public long findScore(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        long sum = 0;
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr,(a,b) -> nums[a] - nums[b]);
        boolean[] vis = new boolean[n];

        for(int i : arr) {
            if(vis[i]) continue;

            sum += nums[i];
            vis[i] = true;
            if(i >= 1)
                vis[i-1] = true;
            if(i < n-1)
                vis[i+1] = true;

        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findScore(new int[]{2,5,6,6,10});
    }
}
