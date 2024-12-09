import java.util.HashSet;
import java.util.Set;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    int answer = 0;
    public int maxUniqueSplit(String s) {

        split(s,new HashSet<>(),0);

        return answer;
    }
    //재귀호출방식 수정
    //start,end 를 나눌 필요가없다
    public void split(String s, Set<String> set,int start){
        if(answer > set.size() + s.length() - start )//조기 종료조건 추가, set에있는 조합과 나머지 문자를 전부 1개로 나누었을때 answer보다 작다면 종료한다
            return;
        if(start >= s.length()){
            answer = Math.max(answer,set.size());
            return;
        }
        for (int i = start+1; i <= s.length(); i++) {
            String tmp = s.substring(start, i);
            if (set.add(tmp)) {
                split(s,set,i);
                set.remove(tmp);
            }
        }

    }

    public static void main(String[] args) {
        SplitaStringIntotheMaxNumberofUniqueSubstrings s = new SplitaStringIntotheMaxNumberofUniqueSubstrings();
        int i = s.maxUniqueSplit("addbsd");
        System.out.println("i = " + i);
    }
}
