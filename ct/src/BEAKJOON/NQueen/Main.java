package BEAKJOON.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int cnt = 0;
    public static int[] crossLeft;
    public static int[] crossRight;
    public static int[] col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        solve();
    }
    public static void solve() {
        crossLeft = new int[2*n+1];
        crossRight = new int[2*n+1];
        col = new int[n];
        dfs(0);
        System.out.println(cnt);
    }
    public static void dfs( int row) {
        if(row == n){
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int leftCrossDesti = n-(i - row);
            int rightCrossDesti = i+row;
            if(col[i] == 0 && crossLeft[leftCrossDesti] == 0 && crossRight[rightCrossDesti] == 0){
                col[i] = 1;
                crossLeft[leftCrossDesti] = 1;
                crossRight[rightCrossDesti] = 1;
                dfs(row+1);
                crossLeft[leftCrossDesti] = 0;
                crossRight[rightCrossDesti] = 0;
                col[i] = 0;
            }
        }

    }
}
