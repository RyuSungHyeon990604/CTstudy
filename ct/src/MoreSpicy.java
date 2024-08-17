import java.util.*;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        Queue<Integer> heap =new PriorityQueue<>();
        for(int i : scoville){
            heap.add(i);
        }
        int c = 0;
        while(heap.size() > 0){
            if(isUp(heap,K)){
                return c;
            }else{
                if(heap.size() == 1 )
                    return -1;
                int a = heap.poll();
                int b = heap.poll() * 2;
                heap.add(a + b);
                c++;
            }
        }

        return -1;
    }

    public boolean isUp(Queue<Integer> scoville, int K) {
        if(scoville.peek() < K){
            return false;
        }
        return true;
    }


}
