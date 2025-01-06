package 프로그래머스.섬연결하기;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        int cnt = 0;
        int index = 0;
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        while(cnt != n-1){
            int[] cur = costs[index];
            int v1 = find(parent,cur[0]);
            int v2 = find(parent,cur[1]);
            if(v1 != v2){
                parent[v2] = v1;
                answer+=cur[2];
                cnt++;
            }
            index++;
        }
        return answer;
    }
    private int find(int[] parent,int v) {
        if(parent[v] == v) return parent[v];
        else return parent[v] = find(parent,parent[v]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }
}
