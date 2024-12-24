package LEETCODE.FindMinimumDiameterAfterMergingTwoTrees;

import java.util.*;

public class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        //트리의 노드마다의 최대 길이를 구한뒤 합을 구한다.
        List<Integer>[] tree1 = new  List[edges1.length+1];
        List<Integer>[] tree2 = new List[edges2.length+1];
        for (int i = 0; i < edges1.length+1; i++) {
            tree1[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges2.length+1; i++) {
            tree2[i] = new ArrayList<>();
        }
        for (int[] edge : edges1) {
            tree1[edge[0]].add(edge[1]);
            tree1[edge[1]].add(edge[0]);
        }
        for (int[] edge : edges2) {
            tree2[edge[0]].add(edge[1]);
            tree2[edge[1]].add(edge[0]);
        }

        int[] arr1 = bfs(tree1,0);
        int[] arr2 = bfs(tree2,0);

        int tree1Max = bfs(tree1,arr1[1])[0];
        int tree2Max = bfs(tree2,arr2[1])[0];

        int mid1 =(tree1Max+1)/2;
        int mid2 = (tree2Max+1)/2;


        return Math.max(Math.max(tree1Max,tree2Max),mid1 + mid2 +1);
    }
    public int[] bfs( List<Integer>[] tree ,int start){
        if(tree.length==0) return new int[]{0,0};
        boolean[] vis = new boolean[tree.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int len = 0;
        int node =start;
        vis[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int next : tree[cur]){
                    if(vis[next]) continue;
                    vis[next] = true;
                    q.offer(next);
                    node = next;
                }
            }
            len++;
        }

        return new int[]{len-1, node};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumDiameterAfterMerge(new int[][]{},new int[][]{});
        int[][] arr = new int[4][];
        Arrays.fill(arr[0],1);
        arr[0][1] = 3;
    }
}
