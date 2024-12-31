package 프로그래머스.등산코스정하기;

import java.util.*;

public class Solution {
    class Node{
        int n;
        int w;
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = new ArrayList<>();
        boolean[] isSummit = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0]).add(new Node(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new Node(paths[i][0], paths[i][2]));
        }
        for (int i = 0; i < summits.length; i++) {
            isSummit[summits[i]] = true;
        }

        return bfs(graph,n,gates,isSummit);
    }
    public int[] bfs(List<List<Node>> graph, int n, int[] gates, boolean[] isSummit){
        int[] answer = {};
        //가중치가 적은 노드부터 처리하도록
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] visited = new int[n+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        for (int i = 0; i < gates.length; i++) {
            q.offer(new int[]{gates[i], 0});
            visited[gates[i]] = 0;
        }
        int intensity = Integer.MAX_VALUE;
        int summit = n+1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(isSummit[cur[0]] && intensity >= cur[1]){
                intensity = cur[1];
                if( intensity == cur[1] && summit > cur[0]){
                    summit = cur[0];
                }
                continue;
            }
            //q는 가중치를 기준으로 내림차순으로 정렬되지만 q의 요소들의 가중치는 점점값이 커짐
            if(cur[1] > intensity){
                continue;
            }
            for(Node nextNode : graph.get(cur[0])){
                if(visited[nextNode.n] > nextNode.w){
                    visited[nextNode.n] = nextNode.w;
                    //q는 가중치를 기준으로 내림차순으로 정렬되지만 q의 요소들의 가중치는 점점값이 커짐
                    q.add(new int[]{nextNode.n, Math.max(cur[1], nextNode.w)});
                }
            }
        }
        answer = new int[]{summit,intensity};
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},new int[]{1,3},new int[]{5});
    }
}
