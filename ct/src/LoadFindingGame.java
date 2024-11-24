import java.util.Arrays;
import java.util.Comparator;

public class LoadFindingGame {
    int i =0 ;
    class Tree{
        int v;
        int x;
        Tree left;
        Tree right;
        public Tree(int v, int x) {
            this.v = v;
            this.x = x;
            left = null;
            right = null;
        }
        public void add(int[] nodeInfo){
            Tree cur =  this;
            int x = nodeInfo[0];
            int v = nodeInfo[2];
            while(cur != null){
                if(cur.x > x){
                    if(cur.left == null){
                        cur.left = new Tree(v, x);
                        break;
                    }
                    cur = cur.left;
                }
                else{
                    if(cur.right == null){
                        cur.right = new Tree(v, x);
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] nodes = new int[n][3];
        for (int i = 0; i <n; i++) {
            nodes[i] = new int[]{nodeinfo[i][0], nodeinfo[i][1], i+1};
        }
        Arrays.sort(nodes,new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o2[1] == o1[1])
                    return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });
        Tree top = new Tree(nodes[0][2], nodes[0][0]);
        for (int i = 1; i < nodes.length; i++) {
            top.add(nodes[i]);
        }
        int[][] answer = new int[2][n];
        order2(top,answer[1]);
        i = 0;
        order1(top,answer[0]);
        return answer;
    }
    public void order1(Tree root,int[] answer){
        if(root == null) return;
        answer[i++] = root.v;
        order1(root.left,answer);
        order1(root.right,answer);
    }
    public void order2(Tree root,int[] answer){
        if(root == null) return;
        order2(root.left,answer);
        order2(root.right,answer);
        answer[i++] = root.v;
    }
    //{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6}}
    public static void main(String[] args) {
        LoadFindingGame game = new LoadFindingGame();
        int[][] a =new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] solution = game.solution(a);
    }
}
 