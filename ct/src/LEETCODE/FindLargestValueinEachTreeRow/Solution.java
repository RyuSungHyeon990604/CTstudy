package LEETCODE.FindLargestValueinEachTreeRow;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
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
    // public List<Integer> largestValues(TreeNode root) {
    //     List<Integer> res = new ArrayList();
    //     if(root == null) return res;
    //     Queue<TreeNode> q= new LinkedList();
    //     q.offer(root);

    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         int rowMax = Integer.MIN_VALUE;
    //         while(size-- > 0){
    //             TreeNode poll = q.poll();
    //             if(poll.left != null){
    //                 q.offer(poll.left);
    //             }
    //              if(poll.right != null){
    //                 q.offer(poll.right);
    //             }
    //             if(poll.val > rowMax){
    //                 rowMax = poll.val;
    //             }
    //         }
    //         res.add(rowMax);
    //     }

    //     return res;
    // }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList();
        dfs(root,0,res);

        return res;
    }
    private void dfs(TreeNode cur,int depth, List<Integer> res){
        if(cur == null) return;
        if(res.size() > depth)
            res.set(depth,Math.max(res.get(depth),cur.val));
        else res.add(cur.val);

        dfs(cur.left,depth+1,res);
        dfs(cur.right,depth+1,res);
    }
}
