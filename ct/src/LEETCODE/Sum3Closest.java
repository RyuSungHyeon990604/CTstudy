import java.util.Arrays;

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        int ans= 0;
        Arrays.sort(nums);

        int minDiff= Integer.MAX_VALUE;

        for (int i =0; i < nums.length; i++) {
            int left  =  i+1;
            int right = nums.length - 1;
            while(left< right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff=  sum-target;
                if(sum == target) {
                    return sum;
                }else{
                    if(Math.abs(diff) <= minDiff) { //target과 가장 작은 차이를 가진 sum이라면
                        ans = sum;
                        minDiff = Math.abs(sum-target);
                    }
                    if(diff > 0){//diff가 0보다 크다면,  sum > target이므로 차이를 더 줄일수있는경우는 right를 줄인다
                        right--;
                    }else{
                        left++;
                    }

                }
            }

        }

        return ans;
    }
}
