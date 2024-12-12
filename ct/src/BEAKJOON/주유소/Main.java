package BEAKJOON.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] edge = new int[n-1];
        int[] cost = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n - 1; i++) {
            edge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        print(n,cost,edge);
    }
    public static void print(int n, int[] cost,int[] edge){
        long cur = cost[0];
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            if(cur > cost[i]){
                cur = cost[i];
            }
            sum += edge[i]*cur;
        }
        System.out.println(sum);
    }
}
