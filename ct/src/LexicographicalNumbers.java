import java.util.*;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        while (result.size() < n) {
            int a = stack.pop();
            if(a <= n)
                result.add(a);
            if(a +1 <= n && (a+1)%10 != 0)
                stack.add(a+1);
            if(a*10 <= n)
                stack.add(a*10);

        }

        return result;
    }

    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        List<Integer> integers = l.lexicalOrder(34);
        System.out.println(integers);
    }
}
