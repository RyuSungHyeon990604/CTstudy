import java.util.LinkedList;
import java.util.Queue;

public class CrossBridge {
    public int solution(int[] stones, int k) {
        int min = 0 ,max = 200_000_000;
        while (min <= max) {
            int mid = (min + max)/2;
            boolean can = canCross(stones, mid, k);
            if (can) {
                min = mid + 1;
            }else{
                max = mid - 1;
            }

        }

        return max;
    }
    public boolean canCross(int[] stones, int num,int limit) {
        int zeroSeq = 0;
        for (int i = 0; i < stones.length; i++) {
            if(stones[i] - num < 0) {
                zeroSeq++;
            }else{
                zeroSeq = 0;
            }
            if(zeroSeq == limit) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CrossBridge c = new CrossBridge();
        int solution = c.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println("solution = " + solution);
    }
}
