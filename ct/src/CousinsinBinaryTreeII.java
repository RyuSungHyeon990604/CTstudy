import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsinBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        TreeNode res = new TreeNode(0);
        Queue<TreeNode[]> q = new LinkedList<>(); // [child,parent]
        q.add(new TreeNode[]{root,new TreeNode(0)});
        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            Map<TreeNode, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                TreeNode[] node = q.poll();
                sum += node[0].val;
                map.put(node[1], map.getOrDefault(node[1],0) + node[0].val);
                q.add(node);
            }
            for (int i = 0; i < n; i++) {
                TreeNode[] node = q.poll();
                node[0].val = sum - map.get(node[1]);
                if (node[0].left != null) {
                    q.add(new TreeNode[]{node[0].left,node[0]});
                }
                if (node[0].right != null) {
                    q.add(new TreeNode[]{node[0].right,node[0]});
                }
            }
        }


        return res;
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
