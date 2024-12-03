package BEAKJOON.텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            //학생수 입력
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[] choice = new int[n+1];

            //팀원선택
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                choice[j] = Integer.parseInt(st.nextToken());
            }
            printCountOfStudentWithoutATeam(n, choice);
        }

    }

    public static void printCountOfStudentWithoutATeam(int n, int[] choice) {
        int[] cycle = new int[n+1];
        int cnt = 0;
        for (int std = 1; std <= n; std++) {
            if(cycle[std] == 0) {
                cnt+=dfs(std, cycle, choice);
            }
        }
        System.out.println(cnt);
    }
    //[현재:]
    public static int dfs(int std, int[] cycle,int[] choice) {
        int current = std;
        int cnt=0;
        //방문한 노드를 제외한 갈수있는 모든 노드를 방문
        while (cycle[current] == 0) {
            cycle[current] = -1;
            current = choice[current];
        }

        //만약 방문한 노드가 아니라면 (while문 조건으로 없어도되는 조건임)
        if(cycle[current] != 1){
            //current는 싸이클을 보유한 노드임
            while (cycle[current] == -1) {
                //싸이클을 순회하면서 방문표시
                cycle[current] = 1;
                current = choice[current];
            }
        }

        //다시 처음으로 돌아와서 남아있는 -1은 싸이클을 가지지못한 노드 즉, 팀이없는 학생
        while (cycle[std] == -1) {
            //각 노드들 방문처리했주고
            cycle[std] = 1;
            std = choice[std];
            //팀 없는 학생들 카운팅
            cnt++;
        }
        return cnt;
    }

}
