import java.util.*;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int m = name.length() -1;
       for (int i = 0; i < name.length(); i++) {
           answer += Math.min(Math.abs(name.charAt(i) - 'A'), 26 - Math.abs(name.charAt(i) - 'A'));
           int nextA = i+1;
           while(nextA < name.length() && name.charAt(nextA)=='A') {
               nextA++;
           }
           m = Math.min(m, i+(name.length()-nextA) + Math.min(i,name.length()-nextA));
       }

        return answer + m;
    }


    public static void main(String[] args) {
        JoyStick js = new JoyStick();
        System.out.println(js.solution("AAAAADBAAELSPUAAAOA"));
    }
}
