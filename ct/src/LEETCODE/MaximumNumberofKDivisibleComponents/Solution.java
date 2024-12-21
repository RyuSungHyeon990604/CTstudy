package LEETCODE.MaximumNumberofKDivisibleComponents;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int[] answer = new int[1];
        List<Integer>[] tree = new List[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        visited[0] = true;
        dfs(tree,0,values,k,visited,answer);
        return answer[0];
    }
    public long dfs(List<Integer>[] tree , int cur, int[] values, int k,boolean[] visited,int[] answer) {
        long childSum = values[cur];
        for (int child : tree[cur]) {
            if(visited[child]) continue;
            visited[child] = true;
            childSum += dfs(tree, child, values, k,visited,answer);
        }
        if(childSum % k == 0) {
            answer[0]++;
            //분리
            return 0;
        }
        return childSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxKDivisibleComponents(7,new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}},new int[]{1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000},7);
    }
}
