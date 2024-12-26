package 프로그래머스.백십옮기기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public String[] solution(String[] s) {
//        int n= s.length;
//        char[] t= new char[]{'1','1','0'};
//
//        for (int i = 0 ; i < n ; i++){
//           StringBuilder replaced =  new StringBuilder();
//           char[] chars = s[i].toCharArray();
//           int cnt = 0;
//           for (int j = 0 ; j < chars.length ; j++){
//               replaced.append(chars[j]);
//               if(replaced.length() < 3 ){
//                   continue;
//               }
//               int curIndexOfReplaced = replaced.length() - 1; ;
//               if(replaced.charAt(curIndexOfReplaced) == '0' && replaced.charAt(curIndexOfReplaced - 1) == '1' && replaced.charAt(curIndexOfReplaced - 2) == '1'){
//                   //110이 들어간다면 제거해준다
//                   replaced.setLength(replaced.length()-3);
//                   cnt++;
//               }
//           }
//           int len = replaced.length();
//           int zeroIndex = 0;
//           for (int j = len-1 ; j >= 0 ; j--){
//               if(replaced.charAt(j) == '0'){
//                   //0의 뒤에 붙여야하므로 +1
//                   zeroIndex = j+1;
//                   break;
//               }
//           }
//           while(cnt-- > 0){
//               replaced.insert(zeroIndex,"110");
//           }
//           s[i] = replaced.toString();
//        }
//        return s;
//    }

    public String[] solution(String[] s) {
        int n= s.length;
        for (int i = 0 ; i < n ; i++){
            List<Character> replaced = new ArrayList<>();
            char[] chars = s[i].toCharArray();
            int cnt = 0;
            for (int j = 0 ; j < chars.length ; j++){
                replaced.add(chars[j]);
                int len = replaced.size();
                if(len < 3) continue;

                if(replaced.get(len-1) == '0' && replaced.get(len-2) == '1' && replaced.get(len-3) == '1'){
                    //110이라면 제거해준ek
                    replaced.remove(--len);
                    replaced.remove(--len);
                    replaced.remove(--len);
                    cnt++;
                }
            }
            int len = replaced.size();
            //1, 11, 111, 110, 100
            //111이라면 맨 앞에 110을 넣어야 사전순으로 가장 빠른 문자열이됨
            //가장 마지막 0 뒤에 110을 넣어야 사전순으로 가장 빠른 문자열이됨
            //즉, 나머지 모든문자가 1이라면 110을 맨앞에 넣어주면 된다.
            int zeroIndex = 0;
            for (int j = len-1 ; j >= 0 ; j--){
                if(replaced.get(j) == '0'){
                    //0다음위치에 넣어야하므로 +1
                    zeroIndex = j+1;
                    break;
                }
            }
            int rem = 0;
            char[] replace = new char[s[i].length()];
            //zeroIndex기준 왼쪽
            for (; rem < zeroIndex ; rem++){
                replace[rem] = replaced.get(rem);
            }
            //110 넣기
            while(cnt-- > 0){
                replace[zeroIndex++] = '1';
                replace[zeroIndex++] = '1';
                replace[zeroIndex++] = '0';
            }
            //나머지 문자 넣기
            for (; rem < replaced.size() ; rem++){
                replace[zeroIndex++] = replaced.get(rem);
            }
            s[i] = new String(replace);
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"1110","100111100","0111111010"});
    }
}
