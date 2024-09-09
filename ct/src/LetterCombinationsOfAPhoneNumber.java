import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        char[] digit = digits.toCharArray();
        char[][] phone = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<char[]> phoneList = new ArrayList<>();

        for(char c : digit) {
            phoneList.add(phone[c -'0']);
        }
        combinations(phoneList,0,res,new StringBuilder());

        return res;
    }

    public void combinations(List<char[]> phoneList, int n,List<String> res, StringBuilder comb) {
        if(phoneList.size() == comb.length()) {
            res.add(comb.toString());
            return;
        }
       for (int i = 0; i < phoneList.get(n).length; i++) {
           char[] phone = phoneList.get(n);
           comb.append(phone[i]);
           combinations(phoneList,n+1, res,comb );
           comb.deleteCharAt(comb.length()-1);
       }
    }
}
