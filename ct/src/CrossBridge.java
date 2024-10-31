import java.util.LinkedList;
import java.util.Queue;

public class CrossBridge {
    public int solution(int[] stones, int k) {
        int i = -1;//처음 위치
        int answer = Integer.MAX_VALUE;
        while (true) {
            if(i+k >stones.length-1 )
                return answer;
            i = getMaxValuesIndex(stones,i+1,i+k);
            if(stones[i] < answer)
                answer = stones[i];
        }
    }
    public int getMaxValuesIndex(int[] stones, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i <= end; i++) {
            if(max < stones[i]) {
                max = stones[i];
                index = i;
            }

        }
        return index;
    }


    public static void main(String[] args) {
        CrossBridge c = new CrossBridge();
        int solution = c.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println("solution = " + solution);
    }
}
