import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestSuminaBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sum = new ArrayList<>();
        sum(root, sum, 0);
        Collections.sort(sum);
        return k > sum.size() ? -1 : sum.get(sum.size() - k);
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

    public void sum(TreeNode root, List<Long> sum, int depth) {
        if (root == null) return;
        if (sum.size() == depth) {
            sum.add((long) root.val);
        } else {
            sum.set(depth, sum.get(depth) + root.val);
        }
        sum(root.left, sum, depth + 1);
        sum(root.right, sum, depth + 1);
    }
}
