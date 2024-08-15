import java.util.*;

public class CrossBridgeTruck {
    public static int sec = 0;
    public static int count =0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> onBridge = new LinkedList<Integer>();
        List<Integer> times =  new ArrayList<Integer>();

        int num = 0;
        while(true){
            incrementTime(times);
            pass(onBridge,times,bridge_length);


            if(num <= truck_weights.length-1 && getSum(onBridge)+truck_weights[num] <= weight){
                onBridge.add(truck_weights[num]);
                times.add(1);
                num++;
            }


            if(count == truck_weights.length){
                break;
            }
        }

        return sec;
    }

    public int getSum(Queue<Integer> onBridge) {
        int sum = 0;
        for(int w : onBridge){
            sum+=w;
        }
        return sum;
    }

    public void incrementTime(List<Integer> times){
        for (int i = 0; i < times.size(); i++) {
            times.set(i, times.get(i)+1);
        }
        sec++;
    }

    public void pass(Queue<Integer> onBridge,List<Integer> times,int bridge_length) {
        if(times.size() != 0 && times.get(0) == bridge_length+1){
            times.remove(0);
            Integer poll = onBridge.poll();
            count++;
        }
    }
}
