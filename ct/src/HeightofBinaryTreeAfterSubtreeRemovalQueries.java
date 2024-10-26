import java.util.HashMap;
import java.util.Map;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries {
    int[] m = new int[100001];
    int maxDepth = 0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        maxDepthLeftToRight(root, 0);
        //중요
        maxDepth = 0;
        maxDepthRigthToLeft(root, 0);
        //중요
        for(int  i = 0;i<queries.length ;i++){
            ans[i] = m[queries[i]];
        }

        return ans;
    }
    //노드의 좌우가 비대칭적일수있기때문에  left -right , right -left 둘다 고려해보야야한다
    // 예를 들어
    //         1
    //        / \
    //       2   3
    //          / \
    //         4   5
    //와 같은 노드가있을때
    // left -right 에 경우 m[i]에는 순회순서대로
    //1 => 0
    //2 => 1
    //3 => 1
    //4 => 2
    //5 => 2 와 같이 들어가지만
    // right - left 에 경우 m[i]에는 순회순서대로
    //1 => 0
    //3 => 1
    //5 => 2
    //4 => 2
    //2 => 2 와 같이 들어가며
    // m[2] 에서 다른 값을 보이게된다 때문에 left -right , right -left 둘다 고려해야한다.
    public void maxDepthLeftToRight(TreeNode root,int depth) {
        if(root == null) return;
        //maxDepth : 현재 가장 큰 depth값, 그리고 현재의 node를 지웠을때 나올수있는 가장 큰 depth라고 할수있다.
        m[root.val]=maxDepth;
        maxDepth = Math.max(maxDepth, depth);
        maxDepthLeftToRight(root.left,depth+1);
        maxDepthLeftToRight(root.right,depth+1);
    }
    public void maxDepthRigthToLeft(TreeNode root,int depth) {
        if(root == null) return;
        m[root.val]=Math.max(maxDepth,m[root.val]);//노드의 비대칭성으로 인해서 maxDepth와 m[root.val]를 비교하여 더 큰값으로 업데이트해야한다.
        maxDepth = Math.max(maxDepth, depth);
        maxDepthRigthToLeft(root.right,depth+1);
        maxDepthRigthToLeft(root.left,depth+1);
    }
}
