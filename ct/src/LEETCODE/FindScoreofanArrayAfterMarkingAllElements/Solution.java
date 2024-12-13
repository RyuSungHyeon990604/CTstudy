package LEETCODE.FindScoreofanArrayAfterMarkingAllElements;

import java.util.*;

public class Solution {
    public long findScore(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        long sum = 0;
        int vis[] = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int v = poll[0];
            int index = poll[1];
            if(vis[index] == 1){
                continue;
            }
            vis[index] = 1;
            sum += v;
            if(index == 0){
                vis[index+1] = 1;
            }else if(index == n-1){
                vis[index-1] = 1;
            }else{
                vis[index-1] = 1;
                vis[index+1] = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findScore(new int[]{2,5,6,6,10});
    }
}
