import java.util.ArrayList;
import java.util.List;

public class Hanoi {
    public int[][] solution(int n) {
        int[][] answer = new int[][]{};
        List<int[]> ans = new ArrayList<>();
        solve(n,1,3,2,ans);
        answer = ans.toArray(new int[ans.size()][]);
        return answer;
    }

    public void solve(int n,int start,int end,int tmp,List<int[]> ans) {
        if(n == 1){
            ans.add(new int[]{start,end});
            return;
        }else{
            //start 에서 end로 옮기기전에는 반드시 가장 큰 원판 을 제외한 모든 원판을 tmp로 옮겨야함
            solve(n-1,start,tmp,end,ans);
            //그후 가장 큰 원판을 start에서 end로 옮긴다
            ans.add(new int[]{start,end});
            //이후 tmp로 옮겨놓았던 원판을 end로 옮긴다
            solve(n-1,tmp,end,start,ans);
        }

    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.solution(3);
    }
}
