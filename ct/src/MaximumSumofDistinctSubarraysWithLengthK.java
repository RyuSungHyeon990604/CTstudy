import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        long  sum = 0;
        int start = 0;
        int end = k-1;
        for(int i = 0 ; i < k ;i++){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        long max = sum;
        if(map.size() < k){
            max = Integer.MIN_VALUE;
        }
        while(end+1 < nums.length){
            sum-=nums[start];
            map.put(nums[start],map.getOrDefault(nums[start],0)-1);
            if(map.get(nums[start]) == 0){
                map.remove(nums[start]);
            }
            sum+=nums[end+1];
            map.put(nums[end+1],map.getOrDefault(nums[end+1],0)+1);
            if(map.size() == k){
                max= Math.max(max, sum);
            }
            start++;
            end++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
