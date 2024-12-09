import java.util.Arrays;

public class SeesawPartner {
    long answer = 0;
    public long solution(int[] weights) {
        Arrays.sort(weights); // 2/3 1/2 3/4
        int[] arr= new int[4001];
        for (int i = weights.length - 1; i >=0 ; i--) {
            double weight = weights[i];
            answer = answer + arr[(int)weight];


            arr[(int)weight] += 1;

            double a =  weight*2/3;
            if(Math.floor(a)==a )
                arr[(int)a] += 1;

            double a2 = weight/2;
            if(Math.floor(a2)==a2 )
                arr[(int)a2] += 1;

            double a3 = weight*3/4;
            if(Math.floor(a3) == a3 )
                arr[(int)a3] += 1;



        }

        return answer;
    }
}
