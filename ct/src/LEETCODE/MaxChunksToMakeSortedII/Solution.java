package LEETCODE.MaxChunksToMakeSortedII;

import java.util.*;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] clone = arr.clone();
        Map<Integer,Integer> count = new HashMap<>();
        int cnt = 0;
        Arrays.sort(clone);
        for(int i = 0; i < clone.length; i++){
            count.put(arr[i],count.getOrDefault(arr[i],0) + 1);
            count.put(clone[i],count.getOrDefault(clone[i],0) - 1);
            boolean flag = true;
            for(int num : count.values()){
                if(num != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt++;
                count.clear();
            }
        }
        return cnt;
    }
    public int maxChunksToSorted2(int[] arr) {
        int[] prefixMax = arr.clone();
        int[] suffixMin = arr.clone();
        int cnt = 1;//기본적으로 1
        for (int i =1; i< arr.length;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],prefixMax[i]);
        }
        for(int i = arr.length-2; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i], suffixMin[i+1]);
        }

        for (int i = 0;i < arr.length-1;i++){
            if(prefixMax[i] <= suffixMin[i+1]){
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxChunksToSorted(new int[]{1,1,0,0,1});
    }
}
