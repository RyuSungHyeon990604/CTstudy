package 프로그래머스.모두0으로만들기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static long cnt = 0;
    public static List<List<Integer>> tree = new ArrayList<>();
    public static boolean[] vis;
    public static  long[] arr;
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        arr = new long[n];
        vis = new boolean[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
            sum += arr[i];
        }
        if (sum != 0) return -1;
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        vis[0] = true;
        dfs(0);

        return cnt;
    }
    public long dfs(int edge) {
        long curValue = arr[edge];
        for (int i=0;  i < tree.get(edge).size() ; i++) {
            int next = tree.get(edge).get(i);
            if (vis[next]) continue;
            vis[next] = true;
            curValue += dfs(next);
        }
        cnt += curValue > 0 ? curValue : -curValue;
        return curValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{-2, 8, -5, -5, -3, 0, 5, 2}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}});
    }
}
