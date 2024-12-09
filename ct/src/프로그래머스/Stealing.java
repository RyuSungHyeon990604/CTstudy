public class Stealing {
    public int solution(int[] money) {
        int[] steal0 = new int[money.length];
        int[] stealAfter0 = new int[money.length];
        steal0[0] = money[0];
        steal0[1] = money[0];//첫번째집에서 도둑질했으므로 인접한 현재인덱스의 최댓값은 steal0[0]과같음
        stealAfter0[0] = 0;
        stealAfter0[1] = money[1];
        //dp[i-2]+money[i] : 인접하지않은 집과 현재의 집을 도둑질했을때 누적값
        //dp[i-1]          : 직전의 집에서 도둑질했을때(현재 집에서는 도둑질을 하지못함)
        //둘중 더 큰 값으로 누적시켜나간다
        for (int i = 2; i < money.length; i++) {
            stealAfter0[i] = Math.max(stealAfter0[i-2]+money[i], stealAfter0[i-1]);
            steal0[i] =  Math.max(steal0[i-2]+money[i], steal0[i-1]);
        }
        // Why steal0[money.length - 2]?  첫번째 집에서 도둑질을 한 경우 집들이 동그랗게 배치되어있으므로 마지막집은 도둑질을 하지못함
        return Math.max(steal0[money.length - 2],stealAfter0[money.length - 1]);
    }

    public static void main(String[] args) {
        Stealing s = new Stealing();
        int solution = s.solution(new int[]{11, 11, 11});
        System.out.println("solution = " + solution);
    }
}
