import java.util.Stack;

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

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        stack1.push(root1);
        stack2.push(root2);
        while(!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            TreeNode pop2 = stack2.pop();
            if(pop.val != pop2.val) return false;
            if(pop.left != null) {
                stack1.push(pop.left);
                if(pop2.left != null && pop.left.val == pop2.left.val) {
                    stack2.push(pop2.left);
                }
                if(pop2.right != null && pop.left.val == pop2.right.val) {
                    stack2.push(pop2.right);
                }
            }

            if(pop.right != null) {
                stack1.push(pop.right);
                if(pop2.left != null && pop.right.val == pop2.left.val) {
                    stack2.push(pop2.left);
                }
                if(pop2.right != null && pop.right.val == pop2.right.val) {
                    stack2.push(pop2.right);
                }
            }

            if(pop.left == null || pop.right == null) {
                if(pop2.left != null && pop2.right != null) return false;
            }
            if(stack1.size() != stack2.size()) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        // root1: [1,2,3,4,5,6,null,null,null,7,8]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        // root2: [1,3,2,null,6,4,5,null,null,null,null,8,7]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);
        FlipEquivalentBinaryTrees f = new FlipEquivalentBinaryTrees();
        boolean b = f.flipEquiv(root1, root2);
        System.out.println(b);
    }
}


