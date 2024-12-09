import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] c = new int[26];
        int[] tmp = new int[26];
        int start = 0 , end = s1.length()-1;
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i) - 'a']++;
        }
        for (int i = start; i <= end ; i++) {
            tmp[s2.charAt(i) - 'a']++;
        }
        while(start <= s2.length() - s1.length()){
           if(chk(c,tmp)){
               return true;
           }else{
               if(start == s2.length() - s1.length())
                   break;
               tmp[s2.charAt(start) - 'a']--;
               start+=1;
               tmp[s2.charAt(end+1) - 'a']++;
               end+=1;
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
        System.out.println(ps.checkInclusion("adc", "dcda"));
    }
}
