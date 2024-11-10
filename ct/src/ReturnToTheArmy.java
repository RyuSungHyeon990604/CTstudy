import java.util.*;
public class ReturnToTheArmy {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        List<Integer>[] list =new List[n+1];
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 1 ; i< n+1 ;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int[] road : roads){
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }
        q.offer(new int[]{destination,0});
        memo[destination] = 0;
        while(!q.isEmpty()){
            int[] poll = q.poll();
            for(int a : list[poll[0]]){
                if(memo[a] == -1){
                    memo[a] = poll[1]+1;
                    q.offer(new int[]{a,poll[1]+1});
                }
            }
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = memo[sources[i]];
        }
        return answer;
    }
}
