public class MaximumSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] memo = new int[100001];
        long  sum = 0;
        int start = 0;
        int end = k-1;
        int count = 0;
        for(int i = 0 ; i < k ;i++){
            sum+=nums[i];
            memo[nums[i]]++;
            if(memo[nums[i]]==1){
                count++;
            }
        }
        long max = sum;
        if(count < k){
            max = Integer.MIN_VALUE;
        }
        while(end+1 < nums.length){
            sum-=nums[start];
            memo[nums[start]]--;
            if(memo[nums[start]]==0){
                count--;
            }
            sum+=nums[end+1];
            memo[nums[end+1]]++;
            if(memo[nums[end+1]]==1){
                count++;
            }
            if(count == k){
                max= Math.max(max, sum);
            }
            start++;
            end++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        MaximumSumofDistinctSubarraysWithLengthK max = new MaximumSumofDistinctSubarraysWithLengthK();
        max.maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3);
    }
}
