package LEETCODE.FinalArrayStateAfterKMultiplicationOperationsI;

import java.util.PriorityQueue;

public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier == 1) return nums;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0] == b[0] ?  a[1] - b[1] : a[0] - b[0]);
        for(int i =0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }

        while(k-- > 0){
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            nums[poll[1]] = poll[0];
            pq.offer(poll);
        }

        return nums;
    }

    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        if(multiplier == 1) return nums;

        while(k-- > 0){
            int minIndex = 0;
            for(int i =0;i<nums.length;i++){
                if(nums[i] < nums[minIndex]){
                    minIndex = i;
                }
            }
            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
