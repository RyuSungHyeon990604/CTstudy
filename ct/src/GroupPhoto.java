import java.util.HashMap;
import java.util.Map;

public class GroupPhoto {
    int ans =0;
    public int solution(int n, String[] data) {
        int[] vis = new int[8];
        char[] h = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        comb(h,n,data,vis,0,new HashMap<>());
        return ans;
    }
    public void comb(char[] h, int n, String[] data, int[] vis, int dept, Map<Character,Integer> map){
        if(dept == h.length){
            boolean can = true;
            for(String rule : data){
                char h1 = rule.charAt(0);
                char h2 = rule.charAt(2);
                char op = rule.charAt(3);
                int c = rule.charAt(4)-'0';
                int t = Math.abs(map.get(h1) - map.get(h2))-1;
                if(op == '='){
                    can = t == c;
                }
                if(op == '>'){
                    can = t > c;
                }
                if(op == '<'){
                    can = t < c;
                }
                if(!can)
                    return;
            }
            ans++;
            return;
        }

        for (int i = 0 ; i < h.length ; i++){
            if(vis[i]==0){
                vis[i]=1;
                map.put(h[i],map.size()+1);
                comb(h,n,data,vis,dept+1,map);
                map.remove(h[i]);
                vis[i]=0;
            }
        }
    }
}
