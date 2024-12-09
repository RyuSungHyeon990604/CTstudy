import java.util.Stack;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            if(c == ')'){
                boolean haveF = false;
                boolean haveT = false;
                while(stack.peek() != '('){
                    char pop = stack.pop();
                    if(pop == 'f')
                        haveF = true;
                    if (pop == 't')
                        haveT = true;
                }
                stack.pop();// ( 제거
                char op = stack.pop();//&,|,!
                if(op == '!'){
                    stack.push(haveF ? 't' : 'f');
                }
                if(op == '|'){
                    stack.push(haveT ? 't' : 'f');
                }
                if(op == '&'){
                    stack.push(haveF ? 'f' : 't');
                }
            }else{
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }

    public static void main(String[] args) {
        ParsingABooleanExpression parser = new ParsingABooleanExpression();
        System.out.println(parser.parseBoolExpr("!(&(f,t))"));
    }
}
