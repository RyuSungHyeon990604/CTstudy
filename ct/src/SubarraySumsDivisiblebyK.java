import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int[] mod = new int[k];
        mod[0] = 1;//
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (sum % k+k)%k;

            res+=mod[rem];

            mod[rem]++;
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK   s = new SubarraySumsDivisiblebyK();
        int i = s.subarraysDivByK(new int[]{8,9,7,8,9}, 8);
        System.out.println("i = " + i);
    }
}
