import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            char peek = stack.peek();
            if((peek == 'A' && s.charAt(i) == 'B') || (peek == 'C' && s.charAt(i) == 'D')){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings sm = new MinimumStringLengthAfterRemovingSubstrings();
        int i = sm.minLength("ABC");
        System.out.println("i = " + i);
    }
}
