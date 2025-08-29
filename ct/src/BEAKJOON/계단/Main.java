package BEAKJOON.계단;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");

		//int n = Integer.parseInt(st.nextToken());
		long res = 0;
		for (int i = 1; i <= 40; i++) {
			res += countStairNumbers(i);
		}

		System.out.println(res);
	}

	// n자리 숫자의 계단수
	private static int countStairNumbers(int n) {
		if (n < 10) {
			return 0;
		}

		//[i][j][bit]
		//앞자리가 1 ~ 9 로 시작하는 수
		//j 자리수
		int[][][] dp = new int[10][n + 1][1 << 10];

		for (int i = 0; i <= 9; i++) {
			dp[i][1][1 << i] = 1;
		}
		for (int j = 2; j <= n; j++) {
			for (int mask = 0; mask < (1 << 10); mask++) {
				for (int first = 0; first < 10; first++) {
					int bit = mask | (1 << first);

					//앞자리가 prefix 인 n 자리수 : 앞자리가 i - 1 or i+1 인 n-1 자릿수 의 합
					if (first < 9) {
						dp[first][j][bit] = (dp[first][j][bit] + dp[first + 1][j - 1][mask]) % MOD;
					}
					if (first > 0) {
						dp[first][j][bit] = (dp[first][j][bit] + dp[first - 1][j - 1][mask]) % MOD;
					}
				}

			}
		}
		int res = 0;
		for (int prefix = 1; prefix < 10; prefix++) {
			res = (res + dp[prefix][n][1023]) % MOD;
		}

		return res;
	}
}
