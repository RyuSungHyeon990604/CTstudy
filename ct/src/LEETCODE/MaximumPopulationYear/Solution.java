package LEETCODE.MaximumPopulationYear;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2051);
        int max = Integer.MIN_VALUE;
        int answer = -1;
        int cnt = 0;
        for(int i=0;i<logs.length;i++){
            int[] cur = logs[i];
            cnt++;
            pq.offer(cur[1]);
            //지금 태어나는 사람이 pq에 담긴사람이 죽은다음일때
            while(!pq.isEmpty() && pq.peek()<=cur[0]){
                cnt--;
                pq.poll();
            }
            if(cnt>max){
                answer = cur[0];
                max = cnt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumPopulation(new int[][]{{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}});
    }
}
