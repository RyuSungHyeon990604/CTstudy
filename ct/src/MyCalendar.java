import java.util.*;

public class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] c : calendar){
            if(start <= c[0] && end >= c[1]) return false;
            if(end < c[1] && end >= c[0]) return false;
            if(start <= c[1] && start > c[0]) return false;
        }
        calendar.add(new int[]{start, end});

        return true;
    }
}
