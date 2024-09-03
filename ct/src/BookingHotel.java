import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BookingHotel {
    public int solution(String[][] book_time) {
        int answer = 0;
        boolean isbooked = false;
        Arrays.sort(book_time, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        ArrayList<Room> hotel = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            for (Room r : hotel) {
                if(r.canBook(book_time[i][0])){
                    r.book(book_time[i][0], book_time[i][1]);
                    isbooked = true;
                    break;
                }
            }
            if(!isbooked){
                Room newRoom = new Room(book_time[i][0], book_time[i][1]);
                hotel.add(newRoom);
            }
            isbooked = false;
        }
        answer = hotel.size();
        return answer;
    }
    static class Room{
        int[] min = new int[60*24];
        public Room(String s, String e) {
            for (int i = toMin(s); i <= toMin(e) +10;i++){
                if(i >= 60 * 24)
                    min[i % (60 * 24)] = 1;
                else
                    min[i] = 1;
            }
        }
        public boolean canBook(String s){
            int sToMin = toMin(s);
            if(min[sToMin] == 1)
                return false;
            return true;
        }
        public void book(String s,String e){
            for (int i = toMin(s); i <= toMin(e);i++){
                if(i >= 60 * 24)
                    min[i % (60 * 24)] = 1;
                else
                    min[i] = 1;
            }
        }
        public int toMin(String s){
            return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
        }
    }

}
