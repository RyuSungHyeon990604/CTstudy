import java.util.Arrays;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int res = nums.length;
        long[] sum = new long[nums.length+1];;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        if(sum[sum.length-1] % p == 0)
            return 0;
        for (int start = 1; start <= nums.length; start++) {
            for (int end = start; end <= nums.length; end++) {
                long subSum = sum[end] - sum[start-1];
                if((sum[sum.length-1]-subSum) % p == 0) {
                    res = Math.min(res,(end-start+1));
                    if(res == 1)
                        return res;
                }
            }
        }

        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP ms = new MakeSumDivisibleByP();
        ms.minSubarray(new int[]{1,2,3},  7);
    }
}
