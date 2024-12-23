package LEETCODE.MinimumNumberofOperationstoSortaBinaryTreebyLevel;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr= new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                arr[i] = poll.val;
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sorted.length; i++) {
                map.put(arr[i], i);
            }
            for (int i = 0; i < sorted.length; i++) {
                if(arr[i] != sorted[i]){
                    res++;
                    int cur = map.get(sorted[i]);
                    map.put(arr[i], cur);
                    arr[cur] = arr[i];
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        solution.minimumOperations(root);
    }
}
