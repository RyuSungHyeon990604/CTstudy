public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int v = 1;
        int step=0;
        int target = n*n;
        if(n%2 ==1){
            target--;
            answer[n/2][n/2] = n*n;
        }
        while (v <= target) {
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

        return answer;
    }

    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        s.generateMatrix(5);
    }
}
