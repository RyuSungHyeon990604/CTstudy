public class Installation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int t = 1;
        for (int i = 0; i < stations.length; i++) {
            int w1 = stations[i] - w;
            int w2 = stations[i] + w;
            if(t < w1){//
                answer += (w1 - t) / (w+w+1);
                if((w1 - t) % (w+w+1)!= 0)
                    answer += 1;
            }
            t = w2 +1;
        }
        if(t <= n){
            answer += (n - t + 1) / (w+w+1);// t = n 이라면 1개 추가설치 필요
            if((n - t + 1) % (w+w+1)!= 0)
                answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Installation inst = new Installation();
        System.out.println();
        inst.solution(16,new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,15},2);
    }
}
