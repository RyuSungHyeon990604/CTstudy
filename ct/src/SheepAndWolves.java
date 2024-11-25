import java.util.*;

public class SheepAndWolves {
    int max = 1;

    public int solution(int[] info, int[][] edges) {
       List[] graph = new List[info.length];
       int[] vis = new int[info.length];
       for (int i = 0; i < graph.length; i++) {
           graph[i] = new ArrayList<>();
       }
       for (int[] edge : edges) {
           graph[edge[0]].add(edge[1]);
       }
       List<Integer> next = new ArrayList<>(graph[0]);
       vis[0] = 1;
       dfs(1,0,vis,next,graph,info);
       return max;
    }
    public void dfs(int sheep,int wolves,int[] vis,List<Integer> next,List[] graph,int[] info){
        if(sheep > wolves && wolves*2 < vis.length) {
            max = Math.max(max,sheep);
            for(int i =0 ; i <next.size() ;i++){
                if(vis[next.get(i)] == 0){
                    vis[next.get(i)] = 1;
                    List<Integer> newNext = new ArrayList<>(next);// next.get(i) 에서 갈수있는 모든 노드들
                    newNext.remove(i);
                    newNext.addAll(graph[next.get(i)]);
                    if(info[next.get(i)] == 0){
                        dfs(sheep+1,wolves,vis,newNext,graph,info);
                    }else{
                        dfs(sheep,wolves+1,vis,newNext,graph,info);
                    }
                    vis[next.get(i)] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SheepAndWolves sheepAndWolves = new SheepAndWolves();
        int solution = sheepAndWolves.solution(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
        System.out.println("solution = " + solution);
    }
}
