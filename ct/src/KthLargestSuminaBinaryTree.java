import java.util.*;

public class KthLargestSuminaBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
       Queue<TreeNode> queue = new LinkedList<>();
       PriorityQueue<Long> pq = new PriorityQueue<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           int n = queue.size();
           long sum = 0;
           for (int i = 0; i < n; i++) {
               TreeNode node = queue.poll();
               if(node.left != null) {
                   queue.add(node.left);
               }
               if(node.right != null) {
                   queue.add(node.right);
               }
               sum += node.val;
           }
           pq.add(sum);
           if(pq.size() > k) {
               pq.remove();
           }
       }
       if(pq.size() < k) return -1;

       return pq.peek();
    }

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


}
