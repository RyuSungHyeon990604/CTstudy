import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberoftheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        //[leaving,chairNum]
        PriorityQueue<int[]> leavingAndChair = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i);
        }

        for (int i = 0; i < times.length; i++) {
            int arrival = times[i][0];
            int leaving = times[i][1];
//            만약 leavingAndChair = [[3,2] [8,1]] 이고 arrival = 12 라면 if문을 사용했을 때, 가장 작은 의자번호는 2가 될 수 있다.
//            즉, while문을 통해조건에 맞는 모든 의자를 비워주어야만 올바른 정답을 얻을 수 있다
//            if (!leavingAndChair.isEmpty() && leavingAndChair.peek()[0] <= arrival) {
//                int chairNumber = leavingAndChair.poll()[1];
//                availableChairs.add(chairNumber);
//            }
            while (!leavingAndChair.isEmpty() && leavingAndChair.peek()[0] <= arrival) {
                int chairNumber = leavingAndChair.poll()[1];
                availableChairs.add(chairNumber);
            }

            int chair = availableChairs.poll();

            if (arrival == targetArrival) {
                return chair;
            }
            leavingAndChair.add(new int[] { leaving, chair });
        }

        return -1;
    }

    public static void main(String[] args) {
        TheNumberoftheSmallestUnoccupiedChair t = new TheNumberoftheSmallestUnoccupiedChair();
        int i = t.smallestChair(new int[][]{{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}}, 6);
        System.out.println("i = " + i);
    }
}
