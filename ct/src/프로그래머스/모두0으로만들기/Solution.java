package 프로그래머스.모두0으로만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public long solution(int[] a, int[][] edges) {
        return bfs(a, edges);
    }

    public long bfs(int[] a, int[][] edges){
        int n = a.length;
        int[] in = new int[n];
        List<List<Integer>> tree= new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        long[] arr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            sum += a[i];
            arr[i] = a[i];
        }
        if(sum != 0) return -1;
        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
            in[edges[i][0]]++;
            in[edges[i][1]]++;
        }
        long count = 0;
        //진입차수가 0인 노드들 추가
        for (int i = 0; i < n; i++) {
            if(in[i] == 1){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            //현재 노드와 연겯돼있는 노드들의 진입차수를 -1
            for (int i = 0; i < tree.get(node).size(); i++) {
                int next = tree.get(node).get(i);
                if(in[next]==0) continue;
                in[next]--;
                arr[next] += arr[node];
                count += Math.abs(arr[node]);
                in[node] = 0;
                arr[node] = 0;
                if(in[next] == 1){
                    queue.add(next);

                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{-2, 8, -5, -5, -3, 0, 5, 2}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}});
    }
}
