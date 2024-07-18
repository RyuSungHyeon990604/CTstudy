import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//{{1, 2, 1}, {2, 3, 3}, {2, 5, 2}, {1, 4, 2}, {3, 5, 1}, {4, 5, 2}}
public class Delivery {
    public static final int INF = 500001;
    int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        distance = new int[N+1];
        for(int i = 0;i<N+1;i++){
            distance[i] = INF;
        }
        distance[1] = 0;
        exp(road,1);
        for(int i : distance){
            if(i != INF && i <= K){
                answer++;
            }
        }
        return answer;
    }
    public void exp(int[][] road,int start){
        for(int[] r :road){
            int s = r[0];
            int end = r[1];
            int weight = r[2];
            //{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}
            if(s == start){
                if(distance[end] == INF || distance[end] >= weight+distance[start]){
                        distance[end] = weight+distance[start];
                        exp(road,end);
                }
            }
            if(end == start){
                if(distance[s] == INF || distance[s] >= weight+distance[start]){
                    distance[s] = weight+distance[start];
                    exp(road,s);
                }
            }
        }
    }
}
