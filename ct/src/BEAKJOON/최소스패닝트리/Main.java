package BEAKJOON.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        print(n,edges);
    }
    public static void print(int n, int[][] edges){
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        int edgesCnt = 0;
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int i = 0;
        int sum =0;
        while(edgesCnt != n - 1){
            int[] cur = edges[i];
            int edgeP1 = find(parent,cur[0]);
            int edgeP2 = find(parent,cur[1]);
            if(edgeP1 == edgeP2){
                i++;
                continue;
            }
            parent[edgeP2] = edgeP1;
            edgesCnt++;
            sum += edges[i][2];
            i++;
        }
        System.out.println(sum);
    }
    public static int find(int[] parent, int v){
        if (parent[v] != v) {
            parent[v] = find(parent, parent[v]);
        }
        return parent[v];
    }
}