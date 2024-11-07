import java.util.LinkedList;
import java.util.Queue;

public class ConstructionOfRaceTrack {
    public int solution(int[][] board) {
        int[][][] dp = new int[board.length][board[0].length][2];// 2가지 방향마다 최솟값을 담도록
        Queue<int[]> q = new LinkedList<>(); // int[]  {curX,curY,direction,cost}
        int[] moveX = new int[]{-1,1,0,0};
        int[] moveY = new int[]{0,0,-1,1};
        for(int[][] d : dp){
            for(int[] p : d){
                p[0] = Integer.MAX_VALUE;
                p[1] = Integer.MAX_VALUE;
            }
        }
        //direction  0 : moveX   1 : moveY
        //(0,0) 으로 어떤 dir 로 들어왔는가?
        q.offer(new int[]{0,0,0,0});
        q.offer(new int[]{0,0,1,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int curX = curr[0], curY = curr[1], curDir = curr[2],curCost = curr[3];
            for (int i = 0; i < 4; i++){//다음에 들어갈 예상 x,y좌표와 dir, cost 들
                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];
                int nextDir = moveX[i] != 0 ? 0 : 1;
                int sumCost = curCost + (nextDir == curDir ? 100 : 600);
                //초반 방향
                // q.offer(new int[]{0,0,0,0});
                // q.offer(new int[]{0,0,1,0});
                //이 두가지 경우때문에 모든 루프를 돌았을때 dp[x][y][0 or 1]에 대한 최솟값이 도출됨

                if(nextX < board.length && nextX>=0 && nextY>=0 && nextY < board[0].length && dp[nextX][nextY][nextDir] > sumCost && board[nextX][nextY] == 0){
                    //지금 당장의 cost가 최솟값이 아닐수있다.
                    dp[nextX][nextY][nextDir] = sumCost;
                    q.offer(new int[]{nextX,nextY,nextDir,sumCost});
                }
            }
        }

        return Math.min(dp[board.length-1][board[0].length-1][0],dp[board.length-1][board[0].length-1][1]);
    }


    public static void main(String[] args) {
        ConstructionOfRaceTrack c = new ConstructionOfRaceTrack();
        int solution = c.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        System.out.println("solution = " + solution);
    }
}
