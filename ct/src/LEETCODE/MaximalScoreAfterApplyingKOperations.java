import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int poll = pq.poll();
            ans += poll;
            pq.offer((int) Math.ceil((double)poll/3));
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximalScoreAfterApplyingKOperations m = new MaximalScoreAfterApplyingKOperations();
        System.out.println(m.maxKelements(new int[]{1,10,3,3,3}, 3));
    }
}
