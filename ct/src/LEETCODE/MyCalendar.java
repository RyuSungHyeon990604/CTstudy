import java.util.*;

public class MyCalendar {
    TreeMap<Integer,Integer> map = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {

        // (1 : 100) <-- return  (start : end)  (250:260)

        Map.Entry<Integer, Integer> a = map.floorEntry(start);
        Map.Entry<Integer, Integer> b = map.ceilingEntry(start);
        if(a==null && b==null) {
            map.put(start, end);
            return true;
        }else if(a==null || b==null){
            if(a == null &&  end <= b.getKey()){
                map.put(start, end);
                return true;
            }
            if(b == null && start >= a.getValue()){
                map.put(start, end);
                return true;
            }
        }else{
            if(start >= a.getValue() && end <= b.getKey()){
                map.put(start, end);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        mc.book(37,50);
        mc.book(33,50);
        mc.book(4,17);
        mc.book(35,48);
        mc.book(8,25);
    }
}
