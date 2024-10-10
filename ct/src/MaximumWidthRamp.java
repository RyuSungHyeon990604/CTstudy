import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) { // 이전의 값보다 작은 값을 가진 인덱스를 넣는다, 즉 스택의 가장 마지막 값은 nums 에서 가장 작은값의 인덱스다.
                stack.push(i);
            }
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                ans = Math.max(ans, j - stack.pop());
            }
        }


       return ans;
    }

    public static void main(String[] args) {
        MaximumWidthRamp max= new MaximumWidthRamp();
        max.maxWidthRamp(new int[]{10,2,3,4,5,1,65,76,8});
    }
}
