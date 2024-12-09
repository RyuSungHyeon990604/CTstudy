import java.util.*;

public class ValidArrangementofPairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Queue<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();//진출차수
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.computeIfAbsent(start, k -> new LinkedList<>()).add(end);
            out.put(start, out.getOrDefault(start, 0) + 1);//진출차수 증가
            out.put(end, out.getOrDefault(end, 0) - 1);//진입차수이므로 진출차수에서 -1
        }
        int start = pairs[0][0];
        for (int k  : out.keySet()){ // 오일러 경로가 성립하려면 시작노드는 진출차수가 진입차수보다 1 많아야한다.
            if(out.get(k) == 1){
                start = k;
                break;
            }
        }
        Deque<int[]> list = new ArrayDeque<>();
        dfs(graph,start,list);
        return list.toArray(new int[list.size()][]);
    }
    public void dfs( Map<Integer, Queue<Integer>> graph, int i,Deque<int[]> list){
        Queue<Integer> integers = graph.get(i);
        while(integers != null && !integers.isEmpty()){
            int poll = integers.poll();
            dfs(graph, poll, list);
            list.addFirst(new int[]{i,poll});
        }
    }


    public static void main(String[] args) {
        ValidArrangementofPairs validArrangementofPairs = new ValidArrangementofPairs();
        validArrangementofPairs.validArrangement(new int[][]{{8,5},{8,7},{0,8},{0,5},{7,0},{5,0},{0,7},{8,0},{7,8}});
    }
}
