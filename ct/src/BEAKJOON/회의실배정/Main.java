package BEAKJOON.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[][] schedule = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        //print(schedule);

    }
    public static void print(int[][] schedule){
        int n = schedule.length;

        Arrays.sort(schedule, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[] pre = schedule[0];
        int cnt = 1;
        for (int i  = 1; i < n; i++){
            int[] cur = schedule[i];
            if(cur[0] >= pre[1]){
                cnt++;
                pre = cur;
            }
        }
        System.out.println(cnt);

    }
}
