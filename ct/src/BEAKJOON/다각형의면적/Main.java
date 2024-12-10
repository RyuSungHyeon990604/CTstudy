package BEAKJOON.다각형의면적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st;
        int[][] list = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        list[n] = list[0];
        print(list,n);
    }
    public static void print(int[][] list,int n) {
        long a =0, b = 0;
        for (int i = 1; i <= n; i++) {
            a += (long) list[i-1][0] * list[i][1];
            b += (long) list[i-1][1] * list[i][0];
        }
        double result = Math.abs(a - b) / 2.0;
        System.out.printf("%.1f",result);
    }
}
