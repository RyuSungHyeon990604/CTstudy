package LEETCODE.FindtheMaximumNumberofFruitsCollected;

public class Solution {
	public int maxCollectedFruits(int[][] fruits) {
		//0,0 은 무조건 + + 방향으로만 이동 가능
		int n = fruits.length;
		int[][] dp = new int[n][n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += fruits[i][i];
		}

		//0, n-1 출발
		dp[0][n-1] = fruits[0][n-1];
		for (int i = 1; i < n-1; i++) {
			int start = Math.max(n-i-1, i+1);
			for (int j = start; j < n; j++) {
				//대각선은 0,0 출발에서 계산 됨
				if(i == j) continue;

				//현재 : i,j
				//3개의 셀 검증, 죄측 상단, 상단, 우측 상단
				//좌측 상단 : i-1, j+1
				//상단 : i-1, j
				//우측 상단 : i-1, j-1
				if(j+1 < n) dp[i][j] = Math.max(dp[i][j], dp[i-1][j+1] + fruits[i][j]);
				if(j-1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + fruits[i][j]);
				dp[i][j] =  Math.max(dp[i][j], dp[i-1][j] + fruits[i][j]);
			}
		}

		//n-1, 0 출발
		dp[n-1][0] = fruits[n-1][0];
		for (int i = 1; i < n-1; i++) {
			int start = Math.max(n-i-1, i+1);
			for (int j = start; j < n; j++) {
				if(i == j) continue;
				//현재 j, i
				//i-1
				//i+1
				if(j-1 >= 0)  dp[j][i] = Math.max(dp[j][i], dp[j-1][i-1] + fruits[j][i]);
				if(j+1 < n)  dp[j][i] = Math.max(dp[j][i], dp[j+1][i-1] + fruits[j][i]);
				dp[j][i] = Math.max(dp[j][i], dp[j][i-1] + fruits[j][i]);
			}
		}



		return res + dp[n-1][n-2] + dp[n-2][n-1];
	}

	private boolean isAvailable(int n, int row, int col) {
		return row < n && col < n && row >= 0 && col >= 0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.maxCollectedFruits(new int[][] {
			{11, 17, 13, 0, 18},
			{13, 12, 10, 12, 19},
			{4, 8, 10, 14, 16},
			{2, 13, 12, 7, 16},
			{4, 9, 7, 4, 3}}
		);


	}
}
