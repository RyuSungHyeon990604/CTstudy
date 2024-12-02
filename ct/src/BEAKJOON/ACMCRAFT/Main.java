package BEAKJOON.ACMCRAFT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] building = new int[n];
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                building[j] = Integer.parseInt(st.nextToken());
            }
            int[][] seq = new int[k][2];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine()," ");
                seq[j] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            int target = Integer.parseInt(new StringTokenizer(br.readLine()," ").nextToken());

            minimumTimeOfTargetBuilding(building,seq,target);
        }
    }

    public static void minimumTimeOfTargetBuilding(int[] building, int[][] seq, int target) {
        int m = building.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] in = new int[m+1];//진입차수
        int[] memo = new int[m+1];
        for (int i = 0; i <= m; i++) {
            graph.add(new ArrayList<>());
            if(i<m){
                memo[i+1] = building[i];
            }

        }
        for (int[] sq :  seq) {
            graph.get(sq[0]).add(sq[1]);
            in[sq[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            if(in[i] == 0){//진입차수가 0인 노드에서 시작
                if(i == target){
                    System.out.println(building[i-1]);
                    return;
                }
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int poll = q.poll();
                for (int next : graph.get(poll)) {
                    int newW = memo[poll] + building[next-1];
                    if(memo[next] < newW) {
                        memo[next] = newW;
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(memo[target]);
    }
}
