import java.util.*;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        p(result,1,n);
        return result;
    }

    public void p(List<Integer> res, int num, int n) {
        if(num > n)
            return;
        res.add(num);
        p(res, num*10, n);
        if(num+1 <= n && num%10 != 9 )  // 19, 20 으로 나오는 문제 해결
            p(res, num+1, n);

    }

    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        List<Integer> integers = l.lexicalOrder(34);
        System.out.println(integers);
    }
}
