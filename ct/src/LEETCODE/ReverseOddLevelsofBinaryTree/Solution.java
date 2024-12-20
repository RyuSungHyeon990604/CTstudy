package LEETCODE.ReverseOddLevelsofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int[] nums = {root.val};
        int depth = 0;
        int index;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if((depth & 1) ==0) nums = new int[size*2];
            index = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if((depth&1) == 1) {
                    cur.val = nums[nums.length-1-i];
                }
                if(cur.left == null || cur.right == null) continue;
                queue.add(cur.left);
                queue.add(cur.right);
                if((depth & 1) ==0){
                    nums[index++] = cur.left.val;
                    nums[index++] = cur.right.val;
                }
            }
            depth++;
        }

        return root;
    }

    public TreeNode reverseOddLevels2(TreeNode root) {
        dfs(root.left,root.right,1);
        return root;
    }

    public void dfs(TreeNode left,TreeNode right,int depth) {
        if(left == null && right == null) return;
        if((depth & 1) == 1){
            int t = left.val;
            left.val = right.val;
            right.val = t;
        }
        dfs(left.left,right.right,depth+1);
        dfs(left.right,right.left,depth+1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
    }
}
