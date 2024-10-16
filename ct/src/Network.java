import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                dfs(computers,vis,i);
                answer++;
            }
        }

        return answer;
    }
    public void dfs(int[][] computers,int[] vis,int targetComputer){
        if(vis[targetComputer] == 1){
            return;
        }
        vis[targetComputer] = 1;

        for(int j = 0 ; j < computers[targetComputer].length ; j++){
            if(computers[targetComputer][j] == 1 && targetComputer!= j){
                dfs(computers,vis,j);
            }
        }

    }

    public static void main(String[] args) {
        Network network = new Network();
        network.solution(4, new int[][]{{1, 1, 0,1}, {1, 1, 0,0}, {0, 0, 1,1},{1,0,1,1}});
    }
}
