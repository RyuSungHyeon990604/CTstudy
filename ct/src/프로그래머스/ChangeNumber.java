import java.util.LinkedList;
import java.util.Queue;

public class ChangeNumber {
    //x -> y
    //x에 n을 더합니다
    //x에 2를 곱합니다.
    //x에 3을 곱합니다.
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] visit = new int[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        while (!q.isEmpty()) {
            int temp = q.poll();
            if (temp == x){
                answer = visit[temp];
                break;
            }
            if(temp - n >= x && visit[temp - n] == 0){
                q.add(temp - n);
                visit[temp - n] = visit[temp] + 1;
            }
            if(temp%2 == 0  && temp/2  >= x && visit[temp/2] == 0){
                q.add(temp/2);
                visit[temp/2] = visit[temp] + 1;
            }
            if(temp%3 == 0  && temp/3  >= x && visit[temp/3] == 0){
                q.add(temp/3);
                visit[temp/3] = visit[temp] + 1;
            }

        }


        return answer;
    }
}
