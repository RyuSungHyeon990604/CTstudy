import java.util.Arrays;

public class CounttheNumberofFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long answer = 0L;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1 ; i++) {
            int left = i, right = nums.length - 1;
            int targetLower = lower - nums[i];
            int targetUpper = upper - nums[i];
            int upperIdx = i;
            int lowerIdx = i;

            while(left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] <= targetUpper) {
                    left = mid + 1;
                    upperIdx =mid;
                }else{
                    right = mid - 1;
                }
            }
            left = i;
            right = nums.length - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] < targetLower) {
                    left = mid + 1;
                    lowerIdx = mid;
                }else{
                    right = mid - 1;
                }
            }
            answer += upperIdx - lowerIdx;
        }

        return answer;
    }
}
