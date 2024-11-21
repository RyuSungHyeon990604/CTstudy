import java.util.*;

public class EditTable {

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
       int[][] nodes= new int[n][4];//[v,up,down,isActive]
        Stack<Integer> recentDeleted = new Stack<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = new int[]{i,i-1,i+1,1};
        }
        int cur = k;
        for(String c : cmd){
            if(c.length() == 1){
                if(c.equals("C")){
                    cur = delete(cur,nodes,recentDeleted);
                }
                if(c.equals("Z")){
                    recover(nodes,recentDeleted);
                }
            }else{
                char direction = c.charAt(0);
                int len = Integer.parseInt(c.split(" ")[1]);
                if(direction == 'U'){
                    while(len!=0){
                        cur = nodes[cur][1];
                        len--;
                    }
                }
                if(direction == 'D'){
                    while(len!=0){
                        cur = nodes[cur][2];
                        len--;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(nodes[i][3] == 1){
                answer.append('O');
            }else{
                answer.append('X');
            }
        }

        return answer.toString();
    }
    public int delete(int cur, int[][] nodes,Stack<Integer> recentDeleted){
        int[] c = nodes[cur];
        c[3] = 0;
        recentDeleted.push(cur);
        if(c[1] >= 0)
            nodes[c[1]][2] = c[2] >= nodes.length ? nodes.length : c[2];
        if(c[2] < nodes.length)
            nodes[c[2]][1] = c[1] < 0 ? -1 : c[1];
        return c[2] < nodes.length ? c[2] : c[1];
    }
    public void recover( int[][] nodes,Stack<Integer> recentDeleted){
        int[] target = nodes[recentDeleted.pop()];
        target[3] = 1;
        if(target[1] >= 0)
            nodes[target[1]][2] = target[0];
        if(target[2] < nodes.length)
            nodes[target[2]][1] = target[0];
    }

    public static void main(String[] args) {
        EditTable editTable = new EditTable();
        editTable.solution(8,2,new String[]{ "D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }
}
