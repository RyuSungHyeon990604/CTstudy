package LEETCODE.TakeGiftsFromtheRichestPile;

import java.util.PriorityQueue;

public class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        long sum=0;
        for(int gift : gifts){
            pq.offer(gift);
            sum+=gift;
        }

        while(k > 0){
            int gift=pq.poll();
            int remain=(int) Math.sqrt(gift);
            pq.offer(remain);
            sum -= gift - remain;
            k--;
        }

        return sum;
    }

    public long pickGifts2(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        long sum=0;
        for(int gift : gifts){
            pq.offer(-gift);
            sum+=gift;
        }

        while(k > 0){
            int gift=-pq.poll();
            int remain=(int) Math.sqrt(gift);
            pq.offer(-remain);
            sum -= gift - remain;
            k--;
        }

        return sum;
    }
}
