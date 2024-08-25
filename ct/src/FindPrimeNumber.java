import java.util.*;

public class FindPrimeNumber {
    int answer = 0;
    public int solution(String numbers) {
        char[] charArray = numbers.toCharArray();
        List<Integer> list = new ArrayList<>();

        int[] visited = new int[charArray.length];
        for (int i = 1; i <= charArray.length; i++) {
            combination(charArray,"",i,visited,list);
        }
        return answer;
    }
    public void combination(char[] charArray, String s, int size, int[] visited, List<Integer> list){
        if(s.equals("0"))
            return;
        if(s.length() == size){
            int i = Integer.parseInt(s);
            if (!list.contains(i)) {
                list.add(i);
                if(isPrime(i)){
                    answer++;
                }
            }
            return;
        }else{
            for(int j=0;j<charArray.length;j++){
                if(visited[j] == 0){
                    visited[j] = 1;
                    s = s + charArray[j];
                    combination(charArray,s,size,visited,list);
                    s = s.substring(0,s.length()-1);
                    visited[j] = 0;
                }
            }
        }
    }
    public boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 ==0 ) return false;
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
