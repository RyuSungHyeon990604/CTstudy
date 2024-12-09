public class ContinuousPulseSubSequenceSum {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        int[] op1 = new int[]{1,-1};
        int[] op2 = new int[]{-1,1};

        dp1[0] = sequence[0];
        dp2[0] = sequence[0] * -1;
        answer =Math.max(dp1[0],dp2[0]);
        for(int i = 1;i<sequence.length;i++){
            dp1[i] = Math.max(sequence[i]*op1[i%2],dp1[i-1]+sequence[i]*op1[i%2]);
            dp2[i] = Math.max(sequence[i]*op2[i%2],dp2[i-1]+sequence[i]*op2[i%2]);
            answer = Math.max(answer, Math.max(dp1[i],dp2[i]));
        }
        return answer;
    }
}
