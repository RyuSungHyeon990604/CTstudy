import java.util.Arrays;

public class ReverseInteger {
    public int reverse(long x) {
        int ans = 0;
        String str = String.valueOf(x < 0 ? -x : x);
        StringBuffer sb = new StringBuffer(str).reverse();

        try{
            ans = Integer.parseInt(String.valueOf(sb));
        }catch(NumberFormatException e){
            return 0 ;
        }
        return x < 0 ? -ans : ans;
    }
}
