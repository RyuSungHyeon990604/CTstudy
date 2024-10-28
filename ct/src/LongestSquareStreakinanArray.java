import java.util.Arrays;

public class LongestSquareStreakinanArray {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int max = 100000;
        int ans = -1;
        int[] vis = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            int r = nums.length - 1, l = i;
            long target = (long)nums[i] * nums[i];
            int len = 1;
            while (l <= r && target <= 100000 && vis[(int) target] == 0) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    vis[(int) target] = 1;
                    target *= target;
                    r = nums.length - 1;
                    l = mid + 1;
                    len += 1;
                } else {
                    if (nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }

            if (len >= 2) {
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSquareStreakinanArray obj = new LongestSquareStreakinanArray();
        int i = obj.longestSquareStreak(new int[]{99999,2,2,3});
        System.out.println("i = " + i);
    }
}
