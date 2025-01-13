package 프로그래머스.두원사이의정수쌍;

public class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1X;
        long r2X;
        for (int y = 1; y < r2; y++) {
            if(y < r1) {
                r1X = (long) Math.sqrt((long)r1*r1 - (long)y*y);
                if(r1X == Math.sqrt((long)r1*r1 - (long)y*y)){
                    r1X-=1;
                }
            } else r1X =0;
            r2X = (long) Math.sqrt((long)r2*r2 - (long)y*y);

            answer += r2X - r1X;
        }

        return answer*4 + (long)(r2-r1+1)*4;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(2, 3);
        System.out.println("solution1 = " + solution1);
    }
}
