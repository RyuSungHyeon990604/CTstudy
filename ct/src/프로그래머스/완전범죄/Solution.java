package 프로그래머스.완전범죄;

import java.util.Arrays;

class Solution {
	/***
	 *
	 * @param info info[i][0] : A 흔적 / info[i][1] : B 흔적
	 * @param n A흔적 제한
	 * @param m B흔적 제한
	 * @return A흔적 최솟값
	 */
	public int solution(int[][] info, int n, int m) {
		int answer = n;
		//dp[i][j] = 물건 i 까지  B의 흔적이 j일때 A 흔적의 최솟값
		int[][] dp = new int[info.length][m];
		for (int i = 0; i < info.length; i++) {
			Arrays.fill(dp[i], n);
		}

		//A도둑이 물건을 훔침
		dp[0][0] = info[0][0];
		//B도둑이 물건을 훔침
		if(info[0][1] < m)
			dp[0][info[0][1]] = 0;

		for (int i = 1; i < info.length; i++) {
			int a = info[i][0];
			int b = info[i][1];

			//i번째 물건마다 모든 B의 흔적의 경우의 수 마다 A흔적의 최솟값을 구해야한다.
			for (int j = 0; j < m; j++) {
				//A도둑이 물건을 훔치는 경우
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a );

				//i번째 물건을 B가 훔칠 수 있을 경우
				if(j + b < m) {
					dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if(answer > dp[info.length - 1][i]) {
				answer = dp[info.length - 1][i];
			}
		}

		return answer >= n ? -1 : answer;
	}

}
