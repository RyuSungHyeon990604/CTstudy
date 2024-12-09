import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int res = nums.length;
        long sum = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i : nums) {
            sum += i;
        }
        long rem = sum % p; // 상쇄햐아하는 나머지
        if (rem == 0) return 0;
        long subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //subSum mod p = subRem , preSubSum mod p = remRem , totalSum mod p = rem 일때
            //subSum = sum[0,i] preSubSum = [0,n] (0<=n<=i) 일때
            //(subSum - preSubSum) mod p = rem 이되는 remRem을 구해야한다
            //(subSum - preSubSum) mod p = (subSum mod p - preSubSum mod p ) mod p = (subRem - remRem) mod p = rem 이고
            // 결국 remRem = subRem - rem 이다 (remRem < 0 이라면 p를 더해주어야한다)
            // 즉 이전에 remRem 값과 동일한 subRem이 나온 i 값이 있다면 [preI,curI] 까지범위가 sum[preI,curI] mod p = rem이게 된다.
            // 즉 [preI,curI]가 이 문제에서 구하는 subArry의 길이다.
            subSum+=nums[i];
            long subRem = subSum%p;
            long remRem  = subRem - rem;
            if (map.containsKey(remRem))
                res = (int) Math.min(res, i - map.get(remRem));

            map.put(subRem, (long)i); // i까지 누적합의 나머지
        }


        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP ms = new MakeSumDivisibleByP();
        ms.minSubarray(new int[]{3, 1, 4, 2},  6);
    }
}
