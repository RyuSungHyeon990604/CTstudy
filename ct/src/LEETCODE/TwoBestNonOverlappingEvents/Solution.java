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
        Arrays.sort(events, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        //종료시점을 기준으로 정렬하므로 가장 빨리 끝나는 이벤트부터 poll됨
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(events[0]);
        int max = 0;
        int ans = 0;

        for(int i = 0; i < events.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                //현재의 이벤트이전에 종료된 이벤트트들 중에서 가장 큰 가중치를 가진 이벤트를 max값으로 설정
                max = Math.max(max, pq.poll()[2]);
            }

            ans = Math.max(ans, max + events[i][2]);
            pq.offer(events[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxTwoEvents(new int[][]{{4,9,8},{5,9,3},{10,12,3}});
    }
}
