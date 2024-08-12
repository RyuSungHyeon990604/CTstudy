import java.util.Stack;
//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 0
//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//  4-3. ')'를 다시 붙입니다.
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//  4-5. 생성된 문자열을 반환합니다.
public class Parentheses {
    public String solution(String p) {
        String answer = p;
        if(isRight(p) || p.equals("")){ //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다
            return p;
        }
        else{
            //2.문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
            int i = getBalanceIndex(p);
            String u = p.substring(0,i+1);
            String v = p.substring(i+1);
            if(isRight(u)){
                //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
                //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
                return u+solution(v);
            }else{
                String s ="";
                //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                //  4-3. ')'를 다시 붙입니다.
                s = "(" + solution(v) + ")";

                //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
                u =u.substring(1,u.length()-1);
                u = revers(u);
                return s + u;
            }
        }
    }


    public boolean isRight(String p){
        int chk = 0;
        for(char c : p.toCharArray()){
            if(c == '(')
                chk += 1;
            else
                chk -=1;

            if(chk < 0)
                return false;
        }
        if(chk == 0)
            return true;

        return false;
    }

    public int getBalanceIndex(String p){
        int c = 0;

        for (int i = 0 ; i<p.length(); i++){
            if(p.charAt(i) == '('){
                c++;
            }else{
                c--;
            }

            if(c == 0)
                return i;
        }

        return 0;
    }

    public String revers(String u){
        String s = "";
        for(int i = 0 ; i<u.length(); i++){
            if(u.charAt(i) == '('){
                s+=')';
            }else
                s+='(';
        }
        return s;
    }
}
