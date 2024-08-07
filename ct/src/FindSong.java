import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindSong {
    public String solution(String m, String[] musicinfos){
        String answer ="(None)";

        // #음 처리
        Map<String, String> t = new HashMap<String, String>();
        t.put("C#","c");
        t.put("D#","d");
        t.put("F#","f");
        t.put("G#","g");
        t.put("A#","a");
        t.put("E#","e");
        t.put("B#","b");

        Iterator<String> iterator = t.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            m = m.replaceAll(key,t.get(key));
        }


        int sort_t = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            int diff = minDiff(musicinfos[i].split(",")[0],musicinfos[i].split(",")[1]);
            String name = musicinfos[i].split(",")[2];
            String song = musicinfos[i].split(",")[3];
            Iterator<String> iterator2 = t.keySet().iterator();
            while(iterator2.hasNext()){
                String key = iterator2.next();
                song = song.replaceAll(key,t.get(key));
            }

            String u = playSong(song,diff);

            //#음 구분 필요
            if(u.contains(m)){
               if(sort_t < diff){
                   sort_t = diff;
                   answer = name;
               }
            }
        }
        return answer;
    }
    /*
     format ==> HH:MM
     */
    public int minDiff(String start, String end){
        //시간을 전부 분단위로 변환
        String[] startsplit = start.split(":");
        String[] endsplit = end.split(":");

        int startMin = Integer.parseInt(startsplit[0])*60 + Integer.parseInt(startsplit[1]);
        int endMin = Integer.parseInt(endsplit[0])*60 + Integer.parseInt(endsplit[1]);

        int diff = endMin - startMin;


        return diff;
    }

    public String playSong(String song, int n){
        String result = "";
        String s = "";

        int t1 = n % (song.length());
        int t2 = n / (song.length());
        for (int i = 0; i < t2; i++) {
            result = result + song;
        }
        for (int i = 0; i < t1; i++) {
            s = s + song.charAt(i);
        }
        result = result + s;
        return result;
    }


}
