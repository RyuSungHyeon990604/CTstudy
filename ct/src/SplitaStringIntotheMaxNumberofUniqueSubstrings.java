import java.util.HashSet;
import java.util.Set;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    int answer = 0;
    public int maxUniqueSplit(String s) {
        for (int i  = 1 ; i <= s.length() ; i++) {
            split(s,new HashSet<>(),0,i,0);
        }
        return answer;
    }

    public void split(String s, Set<String> set,int start,int end,int len){

        if(end > s.length() || start> s.length()){
            if(len == s.length())
                answer = Math.max(answer,set.size());
            return;
        }
        String substring = s.substring(start, end);
        if(!set.add(substring)){
            split(s,set,start,end+1,len);
        }else{
            for (int i = 1; i <= s.length(); i++) {
                split(s,set,end,end+i,len+end-start);
            }
            set.remove(substring);
        }
    }

    public static void main(String[] args) {
        SplitaStringIntotheMaxNumberofUniqueSubstrings s = new SplitaStringIntotheMaxNumberofUniqueSubstrings();
        int i = s.maxUniqueSplit("addbsd");
        System.out.println("i = " + i);
    }
}
