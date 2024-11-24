public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int countNegative1 = 0;
        //음수가 짝수개가 존재한다면 최종적으로 음수를 모두 양수로 만들수있음
        //홀수개라면 최종적으로 1개의 음수가 남음
        for (int i = 0; i < matrix.length; i++) {
            int countNegative2 = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < 0) {
                    sum-=matrix[i][j];
                    countNegative2++;
                    min = Math.min(min, -matrix[i][j]);
                }else{
                    sum+=matrix[i][j];
                    min = Math.min(min, matrix[i][j]);
                }
            }
            if(countNegative2 % 2 != 0){
                countNegative1++;
            }
        }
        if(countNegative1 % 2 != 0){
            sum -= 2*min;
        }
        return sum;
    }
}
