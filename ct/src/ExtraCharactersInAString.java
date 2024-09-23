import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersInAString {
    //s = "abcdefg" dic = ["ab","bc"]
    //1. 여분문자의 갯수를 담는 배열을 만든다  ==> dp[] = new String[s.length]
    //2. dp[0] ~ dp[s.length-1] 까지 초기화 / 여기서 dp에 담기는 값들은 s를 앞에서부터 n개씩 자른문자에서 나올수있는 최대 여분문자의 갯수로한다
    // ex) dp[0] 문자가 0 이므로 여분문자의 최댓값음 0 / dp[1] 은 문자("a") 로 여분문자 최대 1개나올수있다...
    //3. dp[0] = 0
    // dp[1] = 1 ==> sub = "a" 일때 a는 dic에없음, dp[1] = min(dp[1] , dp[0]+1) = 1
    // dp[2] = 2 ==> sub = "ab" 일때 dic에 존재, dp[2] = min(0,dp[1]+1) = 0
    //               sub = "b" 일때는 dic에 없음, dp[2] = min(dp[2],dp[1]+1) == 0

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
               if(dic.contains(sub)){
                   dp[i] = Math.min(dp[i], dp[j]);//i ==3 , j==1 일때 a 와 bc로 나뉜다 여기서 bc는 사전에있으므로 +0 결국 하나 남아있는 a 즉 dp[j]의 값만을 비교해주면 된다
               }else{
                   dp[i] = Math.min(dp[i], dp[j]+i-j );// i==3, j==0 일때 "" 와 abc로 나뉜다. abc는 사전에 없으므로 "" 즉 dp[j]에다 abc문자의 길이 i-j를 더해주어야한다.
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
