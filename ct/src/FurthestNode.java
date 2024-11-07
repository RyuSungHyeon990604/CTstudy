import java.util.*;

public class FurthestNode {
    public int solution(int n, int[][] edge) {
        Map<Integer, Integer> answer = new HashMap<>();
        int[] vis = new int[n+1];
        vis[0] = 1;
        Set<Integer>[] sets = new Set[n+1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            sets[i] = new HashSet<Integer>();
        }
        for (int[] e : edge) {
            sets[e[0]].add(e[1]);
            sets[e[1]].add(e[0]);
        }
        vis[1] = 1;
        for (int e : sets[1]) {
            vis[e] = 1;
            queue.offer(new int[]{e, 1});
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            answer.put(cur[1], answer.getOrDefault(cur[1],0) + 1);
            for (int e : sets[cur[0]]) {
                if (vis[e] == 0) {
                    vis[e] = 1;
                    queue.offer(new int[]{e, cur[1]+1});
                    max = Math.max(max, cur[1]+1);
                }
            }
        }
        return answer.get(max);
    }

    public static void main(String[] args) {
        FurthestNode furthestNode = new FurthestNode();
        furthestNode.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}
