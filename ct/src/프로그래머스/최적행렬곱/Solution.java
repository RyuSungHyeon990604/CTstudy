package 프로그래머스.최적행렬곱;

public class Solution {
	public int solution(int[][] matrix_sizes) {
		int[] arr = new int[matrix_sizes.length+1];
		arr[0] = matrix_sizes[0][0];
		for (int i = 0; i < matrix_sizes.length; i++) {
			arr[i+1] = matrix_sizes[i][1];
		}
		int[][] dp = new int[matrix_sizes.length][matrix_sizes.length];
		for (int len = 1; len < matrix_sizes.length; len++) {
			for (int i = 0; i + len < matrix_sizes.length; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + arr[i] * arr[k+1] * arr[j+1]);
				}
			}
		}
		return dp[0][matrix_sizes.length-1];
	}
}
