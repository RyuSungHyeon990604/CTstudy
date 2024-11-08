public class MaximumXORforEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        //nums에는 2^maximumBit 미만의 수가 들어있으므로
        //nums의 요소들을 XOR연산을 한다면 최댓값으로는 반드시 2^maximumBit-1 가 나올수있다
        //때문에 nums[0] XOR... XOR nums[n] ^ k == 2^maximumBit-1 가 되는 k값은
        //nums[0] XOR... XOR nums[n] XOR ^ 2^maximumBit-1 == k 이다
        //2^maximumBit-1 의 모든 비트는 1이기때문에 XOR 연산시 모든 비트를 반전시킨다
        //nums[0] XOR... XOR nums[n] ^ k 의 모든 비트가 1이 나오려면  nums[0] XOR... XOR nums[n] 과 k 의 비트가 서로 반전되어있어야하므로
        //k 는 nums[0] XOR... XOR nums[n]의 비트를 모두 반전시키면된다
        //때문에  k == nums[0] XOR... XOR nums[n]^(2^maximumBit-1) 이다
        int[] answer = new int[nums.length];
        int s = nums[0];
        for (int i = 0; i <nums.length; i++) {
            if(i>0)
                s= s^nums[i];
            answer[nums.length-1-i] = s ^((1<<maximumBit)-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumXORforEachQuery q = new MaximumXORforEachQuery();
        q.getMaximumXor(new int[]{0,1,1,3}, 2);
    }
}
