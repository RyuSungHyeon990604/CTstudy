import java.util.*;

public class SheepAndWolves {
    int max = 1;
    //노드의 방문여부를 비트마스크를 통해 다룬다.
    public int solution(int[] info, int[][] edges) {
       List[] graph = new List[info.length];
       int[] vis = new int[1<<info.length];
       for (int i = 0; i < graph.length; i++) {
           graph[i] = new ArrayList<>();
       }
       for (int[] edge : edges) {
           graph[edge[0]].add(edge[1]);
       }
       List<Integer> next = new ArrayList<>(graph[0]);
       //처음 방문 노드 0 즉, 1<<0 = 1
       dfs(vis,next,graph,info,1, info.length);

       return max;
    }
    public void dfs(int[] vis,List<Integer> next,List[] graph,int[] info,int n,int len){
        if(vis[n] == 1) return;
        vis[n] = 1;

        //n은 결국 이진수로 보았을때 1인 비트가 방문했음을 뜻함
        int wolves = 0;
        int nodeCount = 0;//방문한 노드의 갯수, 비트가 1인 갯수
        for (int i =0;i<len;i++){
            //n 이 3 이라면 0b11 즉 nodeCount = 2
            if((n & (1<<i)) != 0){
                nodeCount++;
                wolves += info[i];//info의 값이 1인경우 늑대, 0인경우 양이므로 그냥 더해주면됨
            }
        }
        //늑대가 과반수이면 종료
        if(wolves*2 >= nodeCount) return;

        int sheep = nodeCount - wolves;
        max = Math.max(max,sheep);
        for (int i =0;i<next.size();i++){
            int cur = next.get(i);
            List<Integer> newList = new ArrayList<>(next);
            newList.remove(i);
            newList.addAll(graph[cur]);
            //n | (1<<cur) ==> 방문기록을 누적시켜나간다 n == 3일때(0,1을 방문했을때) 4도 방문한다면 3 | (1<<4) = 3+16 = 19
            dfs(vis,newList,graph,info,n | (1<<cur),len);
        }
    }

    public static void main(String[] args) {
        SheepAndWolves sheepAndWolves = new SheepAndWolves();
        int solution = sheepAndWolves.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
        System.out.println("solution = " + solution);
    }
}
