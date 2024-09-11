import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        //[-2,-1,-1,1,1,2,2]
        int b,c,d;
        for (int i = 0; i < nums.length - 3; i++) {
            //*** 중요 *** 다음값을 비교하는것이 아닌, 이전 값을 비교해야한다.
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for (b = i+1; b < nums.length- 2; b++) {
                if(b >i + 1 && nums[b] == nums[b-1]) {
                    continue;
                }
                c = b + 1;
                d = nums.length - 1;
                while(c < d){
                    long sum = (long)nums[b] + (long)nums[c] + (long)nums[d] + (long)nums[i];
                    if(sum == target){
                        ans.add(Arrays.asList( nums[i], nums[b], nums[c],nums[d]));
                        while(c < d && nums[c] == nums[c+1]) c++;
                        c++;
                        while(c < d && nums[d] == nums[d-1]) d--;
                        d--;
                    }else{
                        if(sum < target){
                            c++;
                        }else{
                            d--;
                        }
                    }
                }
            }

        }

        return ans;
    }

}
