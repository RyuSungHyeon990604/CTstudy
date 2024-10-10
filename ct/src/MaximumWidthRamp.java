import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        int max = nums.length-1;
        int i = 0;
        while (max > 0 ) {
            if(nums[i] <= nums[i+max]){
                ans = max;
                break;
            }else{
                if(i+max < nums.length-1){
                    i++;
                }else{
                    max-= 1;
                    i=0;
                }

            }
        }

       return ans;
    }

    public static void main(String[] args) {
        MaximumWidthRamp max= new MaximumWidthRamp();
        max.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
    }
}
