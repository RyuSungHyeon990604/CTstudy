import java.util.*;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int target = 0, left = 1, right = nums.length - 1;
        while (target < nums.length) {
            if (left >= right) {
                while(target < nums.length-1 && nums[target]== nums[target+1] ) {
                    target++;
                }
                target++;
                left = target + 1;
                right = nums.length - 1;
                if(target >= right-1) break;
            }
            if (nums[target] + nums[left] + nums[right] == 0) {
                ans.add(Arrays.asList(nums[target], nums[left], nums[right]));
                while(left < right && nums[right] == nums[right-1]){
                    right--;
                }
                while(left < right && nums[left] == nums[left+1]){
                    left++;
                }
                right--;
                left++;
            } else if (nums[target] + nums[left] + nums[right] > 0) {
                right--;
            } else if (nums[target] + nums[left] + nums[right] < 0) {
                left++;
            }

        }

        return ans;
    }
}
