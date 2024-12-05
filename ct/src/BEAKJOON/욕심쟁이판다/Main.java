package BEAKJOON.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dirRow = {-1,1,0,0};
    static int[] dirCol = {0,0,1,-1};
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        print(map,n);
    }
    public static void print(int[][] map,int n){
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(map,memo,i,j);
                max = Math.max(max,memo[i][j]);
            }
        }
        System.out.println(max);
    }
    public static void dfs(int[][] map,int[][] memo,int row,int col){
        if(memo[row][col] != 0){
            return;
        }
        memo[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            if(newRow < 0 || newRow>= map.length || newCol< 0|| newCol>= map[0].length ) continue;
            if(map[newRow][newCol] > map[row][col]){
                dfs(map,memo,newRow,newCol);
                //항상최댓값을 유지하도록
                memo[row][col] =Math.max(memo[row][col],memo[newRow][newCol] + 1) ;
            }
        }

    }
}
