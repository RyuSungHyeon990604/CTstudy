import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return Collections.emptyList(); //빈 배열을 생성하지 않고, 자바에서 제공하는 빈 리스트를 반환하도록 수정

        List<String> res = new ArrayList<>();
//        char[] digit = digits.toCharArray();
        char[][] phone = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
       //굳이 phoneList를 만들 필요가없음
//        List<char[]> phoneList = new ArrayList<>();
//
//        for(char c : digit) {
//            phoneList.add(phone[c -'0']);
//        }
        combinations(digits.toCharArray(),phone,0,res,new StringBuilder());

        return res;
    }

    public void combinations(char[] digit,char[][] phone, int n,List<String> res, StringBuilder comb) {
        if(comb.length() == digit.length) {
            res.add(comb.toString());
            return;
        }
       for (int i = 0; i < phone[digit[n]-'0'].length; i++) {
           comb.append( phone[digit[n]-'0'][i]);
           combinations(digit,phone,n+1, res,comb );
           //deleteCharAt 보다 약간더 성능이 좋음
           comb.setLength(comb.length()-1);
       }
    }
}
