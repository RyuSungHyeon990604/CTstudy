package LEETCODE.RangeProductQueriesofPowers;

public class Solution {
	private final int MOD = 1_000_000_007;
	public int[] productQueries(int n, int[][] queries) {
		int[] power = getPowers(n);
		int[] prefixSum = new int[power.length+1];
		int[] res = new int[queries.length];
		prefixSum[0] = 0;
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i-1] + power[i-1];
		}

		int i = 0;
		for (int[] query : queries) {
			int pow = prefixSum[query[1]+1] - prefixSum[query[0]];
			res[i++] = getPow(pow);
		}

		return res;
	}

	private int[] getPowers(int n) {
		int bit = Integer.bitCount(n);
		int[] power = new int[bit];
		int i = 0;
		int v = 0;
		while(n > 0) {
			if((n & 1) == 1) {
				power[i++] = v;
			}
			v++;
			n = n >> 1;
		}
		return power;
	}

	private int getPow(int n) {
		long a = 2;
		long res = 1;
		while (n > 0) {
			if ((n & 1) == 1) res = (res * a) % MOD;
			a = (a * a) % MOD;
			n >>= 1;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.productQueries(15, new int[][]{{1,2}});
	}
}
