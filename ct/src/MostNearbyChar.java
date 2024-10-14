import java.util.Arrays;

public class MostNearbyChar {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] ch = new int[26];
        Arrays.fill(ch,-1);
        char[] arr = s.toCharArray();
        for (int i = 0; i<arr.length; i++) {
            if(ch[arr[i] - 'a'] == 0) {
                answer[i] = -1;
            }else{
                answer[i] = i - ch[arr[i] - 'a'];
            }
            ch[arr[i] - 'a'] = i;
        }
        return answer;
    }
}
