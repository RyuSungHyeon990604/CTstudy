import java.util.Arrays;

public class FruitPeddler {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int n = score.length-1;

        while(n-m+1 >= 0){
            answer += score[n-m+1] * m;
            n-=m;
        }


        return answer;
    }

    public static void main(String[] args) {
        FruitPeddler f = new FruitPeddler();
        f.solution(4,3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
    }
}
