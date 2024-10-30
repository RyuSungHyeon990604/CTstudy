import java.util.Arrays;
import java.util.Stack;

public class MinimumNumberofRemovalstoMakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int answer = nums.length;
        int[] dpLIS = new int[nums.length];
        Arrays.fill(dpLIS, 1);
        int[] dpLDS = new int[nums.length];
        Arrays.fill(dpLDS, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpLIS[i] = Math.max(dpLIS[j]+1,dpLIS[i]);
                }
            }
        }
        for (int i = nums.length - 1; i >=0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dpLDS[i] = Math.max(dpLDS[j]+1,dpLDS[i]);
                }
            }
        }
        for (int i = 1; i < nums.length-1; i++) {
            if(dpLIS[i]!=1 && dpLDS[i]!=1){//값이 1인경우에는  dp[i] =1 일때는 자기자신이므로 좌우에 요소가 없는경우이기때문
                answer = Math.min(answer , nums.length-dpLDS[i]-dpLIS[i]+1);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        MinimumNumberofRemovalstoMakeMountainArray obj = new MinimumNumberofRemovalstoMakeMountainArray();
        System.out.println(obj.minimumMountainRemovals(new int[]{100,92,89,77,74,66,64,66,64}));
    }
}
