import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>();

        //sum[i] = nums[0 : i] 의 누적합
        //sum[j] - sum[i] = nums[i : j] 까지의 누적합
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int min  = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {

            while (!deq.isEmpty() && sum[i] - sum[deq.peekFirst()]  >= k  ) {
                min = Math.min(min, i - deq.pollFirst());
            }

            //sum[deq.peekLast()] 는 언제가 위의 sum[i] - sum[deq.peekFirst()]가 적용된다.
            //여기서 sum[i+1] - sum[deq.peekFirst()] 가 >= k 인경우라면
            //sum[deq.peekLast()]  >= sum[i] 일 경우  (여기서 i는 현재의 i)
            //sum[i+1] - sum[i] >= k 가 반드시 만족하게됨 또한  min = Math.min(min, i - deq.pollFirst());의 결과는 더 적거나 같은수로 갱신될 확률이 높다
            //때문에 불필요한 작업을 피하기위해  sum[deq.peekLast()]  >= sum[i] 라면  deq.pollLast();를 통해 없애준다
            while(!deq.isEmpty() && sum[deq.peekLast()]  >= sum[i]) {
                deq.pollLast();
            }
            deq.addLast(i);
        }



        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestSubarraywithSumatLeastK sol = new ShortestSubarraywithSumatLeastK();
        sol.shortestSubarray(new int[]{1400, -500, 50, 1490}, 1500);
    }
}
