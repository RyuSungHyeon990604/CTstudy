import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i], i);
        }

        for (int i = 0; i <= nums.length; i++) {
            int m = target - nums[i];
            //map.get(m) != i : 같은요소를 사용할수없다
            if(map.containsKey(m) && map.get(m) != i) {
                return new int[]{i, map.get(m)};
            }
        }

        return new int[]{};
    }
}
