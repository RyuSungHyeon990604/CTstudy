import java.util.Arrays;
import java.util.PriorityQueue;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        //09:00 부터 t분 간격으로 n회
        int top = 0;
        Arrays.sort(timetable);
        if (timeToInteger(timetable[top]) > 540 + (n - 1) * t) {// 가장 먼저줄을선 크루가 마지막 셔틀버스 도착시간보다 늦었다면
            return integerToHHMM(540 + (n - 1) * t);
        }
        for (int i = 0; i < n; i++) {
            int cur = 540 + i * t;
            int limit = m;
            while (top < timetable.length && cur >= timeToInteger(timetable[top]) && limit > 0) {
                limit--;
                if (i == n - 1 && limit == 0) {//가장 마지막 셔틀버스에서 이미 크루가 limit 만큼 탔다면
                    //버스에 타기위해서는 마지막에 탄 크루보다 적어도 1분 빠르게 줄을 서야함
                    return integerToHHMM(timeToInteger(timetable[top]) - 1);
                }
                top++;
            }
            if (i == n - 1 && limit > 0) {
                //마지막 버스에 탈수있는 모든 크루가 탔지만 추가로 더 탈수있는경우에는
                //게으른 콘은 셔틀버스 도착시간에 맞춰 줄을 서면된다.
                return integerToHHMM(cur);
            }
        }


        return integerToHHMM(540 + (n - 1) * t);
    }

    public int timeToInteger(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    public String integerToHHMM(int time) {
        StringBuilder sb = new StringBuilder();
        int h = time / 60;
        int m = time % 60;
        if (h < 10) sb.append('0');
        sb.append(h);
        sb.append(':');
        if (m < 10) sb.append('0');
        sb.append(m);
        return sb.toString();
    }


    public static void main(String[] args) {
        ShuttleBus shuttleBus = new ShuttleBus();
        String solution = shuttleBus.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
        System.out.println("solution = " + solution);
    }
}
