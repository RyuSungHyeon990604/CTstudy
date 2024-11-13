import java.util.Arrays;

public class CounttheNumberofFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        long upperCount = 0;
        long lowerCount = 0;
        while (left < right) {
            if(nums[left] + nums[right] <= upper) {
                upperCount += right - left;
                left++;
            }else{
                right--;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            if(nums[left] + nums[right] <= lower-1) {
                lowerCount += right - left;
                left++;
            }else{
                right--;
            }
        }
        return upperCount - lowerCount;
    }
}
