package LEETCODE.WaystoExpressanIntegerasSumofPowers;

public class Solution {
	private final int MOD = 1_000_000_007;
	public int numberOfWays(int n, int x) {
		Integer[][] integers = new Integer[n + 1][n+1];
		int dfs = dfs(n, x, 1, integers);

		return dfs;
	}

	public int numberOfWays2(int n, int x) {
		int[] dp  = new int[n+1];
		dp[0] = 1;
		for (int i = 1; Math.pow(i,x) <= n; i++) {
			int j = (int) Math.pow(i,x);
			for (int k = n; k >= j; k--) {
				dp[k] = (dp[k] + dp[k-j]) % 1_000_000_007;
			}
		}

		return dp[n];
	}

	public int dfs(int n, int x, int b, Integer[][] memo) {
		if(n == 0) return 1;
		long pow = (long) Math.pow(b, x);
		if(pow > n) {
			return 0;
		}
		int cnt = 0;
		if(memo[b][n] != null) {
			return memo[b][n];
		}
		cnt = (cnt + dfs((int) (n-pow), x, b+1, memo)) % MOD;
		cnt = (cnt + dfs(n, x, b+1, memo)) % MOD;

		return memo[b][n] = cnt;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int i = s.numberOfWays2(213  , 1);
		System.out.println("i = " + i);
	}
}
