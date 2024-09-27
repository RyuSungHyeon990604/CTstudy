import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    List<int[]> list;
    List<int[]> doubleList;
    public MyCalendarTwo() {
       list = new ArrayList<int[]>();
        doubleList= new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] d : doubleList) {
            if(end <= d[0] || start >= d[1]) {   // (start,end)  d[0]----d[1]  or d[0]----d[1] (start, end)
                continue;
            }else{
                return false;
            }
        }

        for(int[] d : list) {
            if(end <= d[0] || start >= d[1]) {   // (start,end)  d[0]----d[1]  or d[0]----d[1] (start, end)
                continue;
            }else{// (start)  d[0]-(end)---d[1] / d[0]---(start)-d[1]  (end) / d[0] start end d[1] / start d[0] d[1] end
                doubleList.add(new int[]{Math.max(start,d[0]),Math.min(end,d[1])});
            }
        }
        list.add(new int[]{start, end});

        return true;
    }


    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20);
        myCalendarTwo.book(50, 60);
        myCalendarTwo.book(10, 40);
        myCalendarTwo.book(5, 15);
        myCalendarTwo.book(5, 10);
        myCalendarTwo.book(25, 55);
    }
}
