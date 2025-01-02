package 프로그래머스.미로탈출명령어;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //사전순으로 정렬
    String[] dir = {"d","l","r","u"};
    int[] dirX = {1,0,0,-1};
    int[] dirY = {0,-1,1,0};
    String res  = "";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
        dfs(n,m,x,y,r,c,k,sb);
        return res.isEmpty() ? "impossible" : res;
    }
    private void dfs(int n,int m,int x,int y,int r,int c,int k,StringBuilder sb) {
        if(!res.isEmpty()){
            return;
        }
        if(k == 0) {
            if(x == r && y == c) {
                res = sb.toString();
            }
            return;
        }
        if(!canMove(x,y,r,c,k)) return;
        for(int i = 0 ;i<4;i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if (nextY <= 0 || nextX <= 0 || nextX > n || nextY > m) {
                continue;
            }
            sb.append(dir[i]);
            dfs(n,m,nextX,nextY,r,c,k-1,sb);
            sb.setLength(sb.length()-1);
        }
    }
    public boolean canMove(int x, int y, int r, int c, int rem) {
        int diff = Math.abs(x - r) +  Math.abs(y - c);//최소 이동 횟수

        //남은칸수가 최소 이동 횟수보다 작다면 목표까지 도달 불가능
        if(rem < diff) {
            return false;
        }
        //남은 칸수와 최소 이동 횟수의 차이가 짝수가 아니라면 목표까지 도달 불가능
        //다른방향으로 갔다가 제자리로 돌아오기위해서는 2배수의 거리가 필요하기 때문
        if((Math.abs(rem - diff)& 1)  != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(50,50,1,1,50,50,99);
    }
}
