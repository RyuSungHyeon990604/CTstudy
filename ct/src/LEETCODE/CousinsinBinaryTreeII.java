import java.util.*;

public class CousinsinBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer>  sumByDepth = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>(); // [child,parent]
        q.add(root);
        int curSum = root.val;
        root.val *= -1;
        while (!q.isEmpty()) {
            int n = q.size();
            int nextCurSum = 0;// 부모노드들로부터 자식들의 모든합을 미리구한다
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                int t = 0;//형재노드의 합
                if (cur.left != null) {
                    q.add(cur.left);
                    nextCurSum += cur.left.val;
                    t += cur.left.val;
                }
                if (cur.right != null) {
                    q.add(cur.right);
                    nextCurSum += cur.right.val;
                    t += cur.right.val;
                }

                //같은부모를 가진 노드는 동일깊이 노드의 합에서 제외해야하므로 값을 -t 로하여
                // cur.val = curSum + cur.val; 과정에서 동일한 부모를 가진노드들의 합을 빼주도록 한다.
                if (cur.left != null) {
                    cur.left.val = -t;
                }
                if (cur.right != null) {
                    cur.right.val = -t;
                }
                cur.val = curSum + cur.val;
            }
            curSum = nextCurSum;
        }
        return root;
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
