import javax.swing.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueQueue {
    public int[] solution(String[] operations) {
        int[] answer = {};
        Queue<Integer> asc = new PriorityQueue<>((o1,o2) -> o2 - o1);
        Queue<Integer> desc = new PriorityQueue<>((o1,o2) -> o1 - o2);

        for(String command : operations) {
            String cmd = command.split(" ")[0];
            int v = Integer.parseInt(command.split(" ")[1]);
            if(cmd.equals("I")) {
                asc.add(v);
                desc.add(v);
            }
            if(cmd.equals("D")) {
                if(v == 1){
                    if(asc.isEmpty()){
                        continue;
                    }
                    int delete = asc.poll();
                    desc.remove(delete);
                }
                else{
                    if(desc.isEmpty()){
                        continue;
                    }
                    int delete = desc.poll();
                    asc.remove(delete);
                }
            }
        }

        if(asc.isEmpty())
            answer = new int[]{0, 0};
        else{
            answer = new int[]{asc.peek(), desc.peek()};
        }
        return answer;
    }
}
