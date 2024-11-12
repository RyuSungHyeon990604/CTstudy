public class PoppingBalloon {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftToRight = new int[a.length];
        int[] rightToLeft = new int[a.length];
        int min = Integer.MAX_VALUE;
        for (int  i = 0 ; i < a.length; i++){
            min = Math.min(min, a[i]);
            leftToRight[i] = min;
        }
        min = Integer.MAX_VALUE;
        for (int  i = a.length-1 ; i >= 0 ; i--){
            min = Math.min(min, a[i]);
            rightToLeft[i] = min;
        }
        for (int  i = 0 ; i < a.length; i++){
            int leftV = Integer.MAX_VALUE;
            int rigjtV = Integer.MAX_VALUE;
            if(i - 1 >= 0 ){
                leftV = leftToRight[i-1];
            }
            if(i+1 < a.length ){
                rigjtV = rightToLeft[i+1];

            }
            if(leftV < a[i] && rigjtV < a[i] )
                continue;
            answer++;
        }
        return answer;
    }
}
