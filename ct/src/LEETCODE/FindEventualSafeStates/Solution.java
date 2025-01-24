package LEETCODE.FindEventualSafeStates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] isSafe = new boolean[graph.length];
        int n = graph.length;
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = graph[i].length;
        }
        for (int i = 0; i < n; i++) {
            dfs(graph,i,out,isSafe,visited);
        }
        for (int i = 0; i < n; i++) {
            if(isSafe[i]){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int[][] graph, int cur, int[] out, boolean[] isSafe,boolean[] vis){
        if(vis[cur]){
            return isSafe[cur];
        }
        if(out[cur] == 0 || isSafe[cur]){
            return isSafe[cur]=true;
        }
        vis[cur] = true;
        boolean safe = true;
        for(int k = 0; k < graph[cur].length; k++){
            safe &= dfs(graph,graph[cur][k],out,isSafe,vis);
        }

        return isSafe[cur] = safe;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
    }
}
