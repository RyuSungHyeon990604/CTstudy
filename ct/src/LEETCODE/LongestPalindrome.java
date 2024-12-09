public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String answer = "";
        //s = bacad
        if(s.length() == 1) return s;
        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0,1);
        }

        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i+1;
            int start2 = i;
            int end2 = i+2;
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            while(start2 >= 0 && end2 < s.length() && s.charAt(start2) == s.charAt(end2)) {
                start2--;
                end2++;
            }
            if(end - start  > answer.length()) {
                answer = s.substring(start+1, end);
            }
            if(end2 - start2 != 2 && end2 - start2 > answer.length()) {
                answer = s.substring(start2+1, end2);
            }
        }
        if(answer.length() == 0 )
            return s.substring(0,1);
        return answer;
    }
}
