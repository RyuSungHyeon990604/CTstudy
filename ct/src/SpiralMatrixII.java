public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int v = 1;
        int step=0;
        while (v <= n*n) {
            if(step * 2 + 1 == n)
                break;
            for (int i = step; i < n-1-step; i++) {
                answer[step][i] = v++;
            }
            for (int i = step; i < n-1-step; i++) {
                answer[i][n-1-step] = v++;
            }
            for (int i = n-1-step; i >= 1+step; i--) {
                answer[n-1-step][i] = v++;
            }
            for (int i = n-1-step; i >= 1+step; i--) {
                answer[i][step] = v++;
            }
            step++;
        }
        if(n%2 ==1){
            answer[n/2][n/2] = n*n;
        }
        return answer;
    }

    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        s.generateMatrix(20000);
    }
}
