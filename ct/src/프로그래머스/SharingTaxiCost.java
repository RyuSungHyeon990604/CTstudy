public class SharingTaxiCost {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int min = Integer.MAX_VALUE;
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if( i != j )
                    graph[i][j] = 100_001*n;
            }
        }
        for (int[] row : fares) {
            int start = row[0];
            int end = row[1];
            int cost = row[2];
            graph[start][end] = cost;
            graph[end][start] = cost;
        }
        for (int router = 1; router <= n ; router++) {
            for (int start = 1; start <= n ; start++) {
                for (int end = 1; end <= n; end++) {
                    if (graph[start][router] + graph[router][end] < graph[start][end]) {
                        graph[start][end] = graph[start][router] + graph[router][end];
                    }
                }
            }
        }
        for (int share = 1; share <= n ; share++) {
            min = Math.min(min,graph[s][share]+graph[share][a]+graph[share][b]);
        }
        return min;
    }

    public static void main(String[] args) {
        SharingTaxiCost cost = new SharingTaxiCost();
        cost.solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
    }
}
