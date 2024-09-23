import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersInAString {


    public int minExtraChar(String s, String[] dictionary) {
       int res = 0;
       Set<String> dic = new HashSet<String>();
       for (String d : dictionary) {
           dic.add(d);
       }
       int[] dp = new int[s.length() + 1];
       for (int i = 1; i <= s.length(); i++) {
           dp[i] = i;
       }

       for (int i = 1; i <= s.length(); i++) {
           for (int j= 0 ; j< i ;j++){
               String sub = s.substring(j,i);
               if(dic.contains(sub)){//j == 0일때 사전에 존재하는것은 여분문자가 0임 / 0이 아닐때라면 문자는 dp[j] + 추가 문자의 갯수
                   dp[i] = Math.min(dp[i], dp[j]);
               }else{
                   dp[i] = Math.min(dp[i], dp[j]+i-j );
               }
           }
       }
       return dp[dp.length-1];
    }

    public static void main(String[] args) {
        ExtraCharactersInAString ex = new ExtraCharactersInAString();
        ex.minExtraChar("abc",new String[]{"bc"});
    }

}
