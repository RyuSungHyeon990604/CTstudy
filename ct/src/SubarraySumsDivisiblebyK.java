import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (sum % k+k)%k;
            if (map.containsKey(rem)) {
                res+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK   s = new SubarraySumsDivisiblebyK();
        int i = s.subarraysDivByK(new int[]{8,9,7,8,9}, 8);
        System.out.println("i = " + i);
    }
}
