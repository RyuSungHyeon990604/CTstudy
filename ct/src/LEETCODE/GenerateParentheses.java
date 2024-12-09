import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        newGenerateParenthesis(new StringBuilder(), res,0, 0,n);
        return res;
    }

    public void newGenerateParenthesis(StringBuilder s,List<String> res,int open,int close,int n) {
        if(close==n) {
            res.add(s.toString());
            return;
        }else{
            if(open < n) {// ( 을 추가할수있으면
                newGenerateParenthesis(s.append("("),res,open+1,close,n);
                s.setLength(s.length()-1);
            }
            if(close<open) {// ) 갯수보다 ( 가 많으면
                newGenerateParenthesis(s.append(")"),res,open,close+1,n);
                s.setLength(s.length()-1);
            }
        }
    }
// 불필요한 괄호까지 전부 만든다.  그래서 비효율적
//    public void generateParenthesis(StringBuilder s,List<String> res,int depth,int n) {
//        if(depth==2*n) {
//            if(isParenthesis(s)){
//                res.add(s.toString());
//            }
//            return;
//        }else{
//            generateParenthesis(s.append("("),res,depth+1,n);
//            s.setLength(s.length()-1);
//            generateParenthesis(s.append(")"),res,depth+1,n);
//            s.setLength(s.length()-1);
//        }
//    }
//
//    public boolean isParenthesis(StringBuilder s){
//        char[] charArray = s.toString().toCharArray();
//        int chk=0;
//        if(charArray[0]==')'){
//            return false;
//        }
//        for(char c:charArray) {
//            if(c=='(') {
//                chk++;
//            }else{
//                chk--;
//            }
//            if(chk < 0) {
//                return false;
//            }
//        }
//        if(chk==0) {
//            return true;
//        }
//        return false;
//    }
}
