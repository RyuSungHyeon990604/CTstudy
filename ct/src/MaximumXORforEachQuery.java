public class MaximumXORforEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        int s = nums[0];
        for (int i = 0; i <nums.length; i++) {
            if(i>0)
                s= s^nums[i];
            int t = s;
            int n = (1<<maximumBit) - 1;
            int idx = 0;
            if(t == n){
                answer[nums.length-1-i] = 0;
                continue;
            }
            while (t != 0) {
                if((t&1) == 1) {
                    n = n - (1 << idx);
                }
                idx++;
                t = t>>1;
            }
            answer[nums.length-1-i] = n;
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumXORforEachQuery q = new MaximumXORforEachQuery();
        q.getMaximumXor(new int[]{0,1,1,3}, 2);
    }
}
