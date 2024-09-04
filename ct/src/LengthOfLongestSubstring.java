import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if(arr[s.charAt(end)] >= start){
                start = arr[s.charAt(end)] + 1;
            }
            arr[s.charAt(end)] = end;
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}
