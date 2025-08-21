package LEETCODE.CountSubmatricesWithAllOnes;

public class Solution {
	public int numSubmat(int[][] mat) {
		int res = 0;
		int[][] rows = new int[mat.length][mat[0].length];
		//(i, j) == 1일때 추가도이었을경우
		//(i, j) 을 포함하는 추가되는 부분 행렬의 갯수
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				if(j == 0)
					rows[i][j] = mat[i][j];
				else
					rows[i][j] = mat[i][j] == 0 ? 0 : rows[i][j-1] + 1;

				int min = Integer.MAX_VALUE;
				for (int h = i ; h >= 0 ; h--) {
					if(rows[h][j] == 0) break;
					min = Math.min(min, rows[h][j]);

					res += min;
				}
			}
		}
		return res;
	}
}
