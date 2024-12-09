import java.util.Arrays;
//chk
public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int jumpIndex = 0;

        //점프할수있는 모든 경우의 수까지 기다렸다가, 가장 멀리갈수있는 점프를 골라서 점프한다
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, i + nums[i]);//가장 멀리갈수있는 점프
            if(i == jumpIndex){//점프할수있는 모든 경우의 수까지 기다렸다가
                res++;//점프한다
                jumpIndex = max;// 기다리는구간 설정
            }
        }


        return res;
    }


    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{1,2,3,4,5}));
    }
}
