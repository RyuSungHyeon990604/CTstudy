import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rank {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] winners= new List[n+1];
        List<Integer>[] losers= new List[n+1];
        for (int i = 1; i <= n; i++) {
            winners[i] = new ArrayList<>();//i가 이긴선수들
            losers[i] = new ArrayList<>();//i를 이긴선수들
        }
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            winners[winner].add(loser);
            losers[loser].add(winner);
        }
        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new LinkedList<>();
            int[] vis = new int[n+1];
            q.add(i);
            vis[i] = 1;
            int winnerC = 0;
            //i가 이긴선수들 카운팅
            while (!q.isEmpty()) {
                int poll = q.poll();
                for (int loser : winners[poll]) {//loser가 이긴선수들 또한 i가 이긴선수들이다.
                    if(vis[loser] == 0) {
                        vis[loser] = 1;
                        q.add(loser);
                        winnerC++;
                    }
                }
            }

            vis = new int[n+1];
            vis[i] = 1;
            int loserC = 0;
            q.add(i);
            //i를 이긴선수들 카운팅
            while (!q.isEmpty()) {
                int poll = q.poll();
                for (int winner : losers[poll]) {//winner를 이긴 선수또한 i를 이긴선수다
                    if(vis[winner] == 0) {
                        vis[winner] = 1;
                        q.add(winner);
                        loserC++;
                    }
                }
            }
            if(loserC + winnerC == n-1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Rank rank = new Rank();
        rank.solution(5,new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }
}
