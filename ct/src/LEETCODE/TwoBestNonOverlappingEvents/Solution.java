package LEETCODE.TwoBestNonOverlappingEvents;

import java.util.*;

//Maximum Population Year -> 1854
//Points That Intersect With Cars -> 2848
//Car Pooling -> 1094
//My Calendar II -> 731
//Shifting Letters II -> 2381
//Perfect Rectangle -> 391
//Rectangle Area II -> 850
//Number of Flowers in Full Bloom -> 2251
public class Solution {
    public int maxTwoEvents(int[][] events) {
        int max = Integer.MIN_VALUE;
        int n = events.length;
        Arrays.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int[] suffixArr = new int[n];
        suffixArr[n-1] = events[n-1][2];
        //i번째 이벤트 이후에 나올수있는 최대 value
        for (int i = n-2; i >= 0; i--) {
            suffixArr[i] = Math.max(events[i][2], suffixArr[i+1]);
        }
        for (int i = 0; i < n; i++) {
            int left = i, right = n-1;
            int nextEvt = -1;
            //현재 인벤트 종료후에 나오는 다음 이벤트의 위치를 찾는다. 즉 겹치지않는 다음이벤트
            while (left <= right) {
                int mid = (left + right) / 2;
                if (events[mid][0] > events[i][1]) {
                    right = mid-1;
                    nextEvt = mid;
                }else{
                    left = mid+1;
                }
            }
            if (nextEvt == -1) {//다음 이벤트가 없다면
                //현재 이벤트의 value를 최댓값
                max = Math.max(max, events[i][2]);
            }else{
                max = Math.max(max, events[i][2] + suffixArr[nextEvt]);
            }
        }



        return max;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxTwoEvents(new int[][]{{4,9,8},{5,9,3},{10,12,3}});
    }
}
