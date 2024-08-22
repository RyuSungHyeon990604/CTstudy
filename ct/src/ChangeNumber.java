import java.util.LinkedList;
import java.util.Queue;

public class ChangeNumber {
    //x -> y
    //x에 n을 더합니다
    //x에 2를 곱합니다.
    //x에 3을 곱합니다.
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] visit = new int[y];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,0});
        int count = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int v = temp[0];
            int depth = temp[1];
            if (v == y){
                answer = depth;
                break;
            }
            if(v < y &&  visit[v] == 0){
                visit[v] = 1;
                q.add(new int[]{v + n,depth+1});
                q.add(new int[]{v * 2,depth+1});
                q.add(new int[]{v * 3,depth+1});
            }
        }


        return answer;
    }
}
