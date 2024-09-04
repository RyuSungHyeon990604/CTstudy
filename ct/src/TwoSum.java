import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int[][] numsc = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsc[i][0] = nums[i];
            numsc[i][1] = i;
        }
        Arrays.sort(numsc, new Comparator<int[]>() {
            public int compare(int[] nums1, int[] nums2) {
                return nums1[0] - nums2[0];
            }
        });
        int start = 0, end = nums.length - 1;
        int sum = numsc[start][0] + numsc[end][0];
        while(true){
            sum =numsc[start][0] + numsc[end][0];
            if(sum == target){
                break;
            }else{
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        ans = new int[]{numsc[start][1], numsc[end][1]};
        return ans;
    }
}
