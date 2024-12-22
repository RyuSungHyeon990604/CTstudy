package LEETCODE.FindBuildingWhereAliceandBobCanMeet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        List<List<int[]>> deferredQ = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            deferredQ.add(new ArrayList<>());
        }
        for (int i = 0; i < queries.length; i++) {
            int start = Math.min(queries[i][0], queries[i][1]);
            int end = Math.max(queries[i][0], queries[i][1]);
            if (start == end || heights[start] < heights[end]) {
                res[i] = end;
                continue;
            }
            //나중에 처리할 쿼리를 저장해놓는다
            deferredQ.get(end).add(new int[]{heights[start], i});//end 위치 이후에 heights[start]보다 큰 인덱스
        }
        for (int i = 0; i < heights.length; i++) {
            //현재위치 높이
            int curHeight = heights[i];

            //현재위치에서 처리할 쿼리를 우선순위 큐에 넣는다.
            for (int[] q : deferredQ.get(i)) {
                pq.offer(q);
            }

            //만약 현재위치의 높이가 처리할 쿼리의 높이보다 높다면 res에 할당
            //처리하지못한 쿼리는 다음 높이에서 계속 처리
            while (!pq.isEmpty() && curHeight > pq.peek()[0]) {
                int index = pq.poll()[1];
                res[index] = i;
            }
        }
        return res;
    }
//    팬윅트리 BIT : Binary Index Tree 기초적인 누적합
//    public int[] BinaryIndexTree(int[] heights, int[][] queries) {
//        int[] tree = new int[heights.length+1];
//        for (int i = 0; i < heights.length; i++) {
//            add(tree,i+1,heights[i]);
//        }
//        return tree;
//    }
//    private void add(int[] tree,int i,int num){
//        while(i<tree.length){
//            tree[i] += num;
//            i +=(i&-i);
//        }
//    }
//    private long getSum(int[] tree,int i){
//        long result = 0;
//        while(i > 0){
//            result += tree[i];
//            i -= (i&-i);
//        }
//        return result;
//    }

//    //팬윅트리 BIT : 최대최소 값으로 응용 미완성
//    //팬윅트리에서 구간의 최솟값을 구하려면 2개의 트리가 필요
//    public int[] BinaryIndexTree(int[] heights, int[][] queries) {
//        int[] tree = new int[heights.length+1];
//        int[] tree2 = new int[heights.length+1];
//        Arrays.fill(tree, Integer.MAX_VALUE);
//        Arrays.fill(tree2, Integer.MAX_VALUE);
//        for (int i = 0; i < heights.length; i++) {
//            update(i+1,heights[i],tree);
//            update2(i+1,heights[i],tree2);
//        }
//        int v = Integer.MAX_VALUE;
//
//        // [a, b] 구간을 두 부분으로 나누어 처리
//        int prev = 4;
//        int curr = prev + (prev & -prev);
//        while (curr <= 5) {
//            v = Math.min(v, tree2[prev]);
//            prev = curr;
//            curr = prev + (prev & -prev);
//        }
//
//        v = Math.min(v, heights[prev]);
//
//        prev = 5;
//        curr = prev - (prev & -prev);
//        while (curr >= 4) {
//            v = Math.min(v, tree[prev]);
//            prev = curr;
//            curr = prev - (prev & -prev);
//        }
//
//
//        return tree;
//    }
//    // 트리 업데이트 (왼쪽 방향)
//    public void update(int i, int x,int[] tree) {
//        while (i <= tree.length) {
//            tree[i] = Math.min(tree[i], x);
//            i += (i & -i); // 부모 노드로 이동
//        }
//    }
//
//    // 트리 업데이트 (오른쪽 방향)
//    public  void update2(int i, int x,int[] tree) {
//        while (i > 0) {
//            tree[i] = Math.min(tree[i], x);
//            i -= (i & -i); // 부모 노드로 이동
//        }
//    }
}
