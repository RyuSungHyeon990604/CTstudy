import java.util.Arrays;

public class ReverseInteger {
//    public int reverse(long x) {
//        int ans = 0;
//        String str = String.valueOf(x < 0 ? -x : x);
//        StringBuffer sb = new StringBuffer(str).reverse();
//
//        try{
//            ans = Integer.parseInt(String.valueOf(sb));
//        }catch(NumberFormatException e){
//            return 0 ;
//        }
//        return x < 0 ? -ans : ans;
//    }
    public int reverse(long x) {
        long ans = 0;
        long n = Math.abs(x);

        while(n>0){
           int mod = (int) n % 10;
           n = n / 10;
           ans = ans * 10 + mod;
           if(ans > Integer.MAX_VALUE)
               return 0;
        }
        return x > 0 ? (int) ans :(int) -ans;
    }
}
