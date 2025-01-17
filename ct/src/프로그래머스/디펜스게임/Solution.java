package 프로그래머스.디펜스게임;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k >= enemy.length) return enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (;i < enemy.length; i++) {
            pq.offer(-enemy[i]);
            if(n >= enemy[i]){
                n-=enemy[i];
            }else{
                if(k>0){
                    n-=pq.poll();
                    n-=enemy[i];
                    k--;
                }else return i;
            }
        }
        return i;
    }

}
