import java.util.HashMap;
import java.util.Map;

public class TreeXTiling {

    public int solution(int n) {
        long[] a = new long[n+1];
        if(n%2==1)
            return 0;
        a[2] = 3;
        //fn = fn-2*3 + fn-4*2 ... + f2 *2 + 2

        //f2 = 3
        //f4 = f2*3             + 2
        //f6 = f4*3             + f2*2 + 2
        //f8 = f6*3             + f4*2+ f2*2 + 2
        long sum = 1;
        for(int i=4;i<=n;i+=2){
            a[i] = (a[i-2]*3 + 2*sum)% 1_000_000_007;
            sum += a[i-2]; //sum 은 fn-4 fn-6 ... f2 이므로 a[i] 가 아닌 a[i-2] 를 해주어야한다.
        }

        return (int)a[n];
    }


    public static void main(String[] args) {
        TreeXTiling tree = new TreeXTiling();
        int solution = tree.solution(8);
        System.out.println("solution = " + solution);
    }
}
