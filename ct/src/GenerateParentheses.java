import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generateParenthesis(new StringBuilder(), res, 0,n);
        return res;
    }



    public void generateParenthesis(StringBuilder s,List<String> res,int depth,int n) {
        if(depth==2*n) {
            if(isParenthesis(s)){
                res.add(s.toString());
            }
            return;
        }else{
            generateParenthesis(s.append("("),res,depth+1,n);
            s.setLength(s.length()-1);
            generateParenthesis(s.append(")"),res,depth+1,n);
            s.setLength(s.length()-1);
        }
    }

    public boolean isParenthesis(StringBuilder s){
        char[] charArray = s.toString().toCharArray();
        int chk=0;
        if(charArray[0]==')'){
            return false;
        }
        for(char c:charArray) {
            if(c=='(') {
                chk++;
            }else{
                chk--;
            }
            if(chk < 0) {
                return false;
            }
        }
        if(chk==0) {
            return true;
        }
        return false;
    }
}
