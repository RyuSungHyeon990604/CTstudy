import java.util.*;

public class Clothes {
    //[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
           map.put(cloth[1],map.getOrDefault(cloth[1], 0)+1);
        }

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            answer *= (map.get(key)+1);
        }
        answer -= 1;

        return answer;
    }
}
