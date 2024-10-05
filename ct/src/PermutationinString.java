import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int[] c = new int[26];
        int[] tmp = new int[26];
        int start = 0 , end = 0;
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i) - 'a']++;
        }
        while(end < s2.length()){
            if(c[s2.charAt(end)-'a'] > 0 && tmp[s2.charAt(end) - 'a'] + 1 <= c[s2.charAt(end)-'a']){
                tmp[s2.charAt(end) - 'a']++;
                end++;
                if(end - start == s1.length()){
                    if(chk(tmp , c))
                        return true;
                }
            }else{
                start++;
                end = start;
                Arrays.fill(tmp,0);
            }
        }
        return false;
    }

    public boolean chk(int[] c,int[] tmp){
        for (int i = 0; i < c.length; i++) {
            if(c[i] != tmp[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationinString ps = new PermutationinString();
        System.out.println(ps.checkInclusion("ab", "eidbdaooo"));
    }
}
