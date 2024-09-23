import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0;
        int[] maxDestination = new int[nums.length];
        int destination = nums.length - 1;
        while (destination > 0) {
            for (int i = destination ;   i >= 0; i--) {
                if(i+nums[i] >= destination){
                    maxDestination[destination] = i;
                }
            }
            destination = maxDestination[destination];
            res++;
        }


        return res;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{1,2,3,4,5}));
    }
}
