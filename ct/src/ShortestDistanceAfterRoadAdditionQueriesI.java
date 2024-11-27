import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            list.get(queries[i][0]).add(queries[i][1]);
            int[] vis = new int[n];
            q.add(0);
            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int poll = q.poll();
                    if (poll == n - 1) {
                        answer[i] = step;
                        q.clear();
                        break;
                    }
                    for (int k : list.get(poll)) {
                        if (vis[k] == 0) {
                            vis[k] = 1;
                            q.offer(k);
                        }
                    }
                    if (vis[poll + 1] == 0) {
                        vis[poll + 1] = 1;
                        q.offer(poll + 1);
                    }

                }
                step++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesI sol = new ShortestDistanceAfterRoadAdditionQueriesI();
        sol.shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}});
    }
}
