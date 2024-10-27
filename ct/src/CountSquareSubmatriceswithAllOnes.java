public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int n = Math.max(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    ans+=1;
                    for (int k = 1; k < n; k++) {
                        boolean check = true;
                        for (int l = i ; l <= i+k; l++) {
                            for (int m = j ; m <= j+k; m++) {
                                if(l >= matrix.length || m >= matrix[0].length) {
                                    check = false;
                                    break;
                                }
                                if(matrix[l][m] == 0){
                                    check = false;
                                    break;
                                }
                            }
                            if(!check) break;
                        }
                        if(check) ans+=1;
                    }
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes cs = new CountSquareSubmatriceswithAllOnes();
        cs.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}});
    }
}
