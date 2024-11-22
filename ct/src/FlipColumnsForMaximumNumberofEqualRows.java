import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();
        for(int[] row : matrix){
            String pattern = getPattern(row);
            map.put(pattern,map.getOrDefault(pattern,0)+1);
        }
        int max = 0;
        for (int v : map.values()){
            max =Math.max(max, v);
        }
        return max;
    }
    //[0,1,1]
    //[1,0,0] 은 첫번째 열을 뒤집었을때 두 행모두 같은 숫자를 가진다.
    //즉 각 row 의 패턴이 같을때 , 두 row가 동일 또는 완전히 반전되어있는 경우를 카운팅하면 된다.
    public String getPattern(int[] row){
        StringBuilder key = new StringBuilder();
        int pre = row[0];
        int freq = 0;
        for (int  i = 0; i < row.length; i++){
            if(pre == row[i]){
                freq++;
            }else{
                key.append(freq);
                freq = 1;
                pre = row[i];
            }
        }
        return key.toString();
    }
}
