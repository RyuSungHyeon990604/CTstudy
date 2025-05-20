package LEETCODE.ZeroArrayTransformationI;

public class Solution {
	public boolean isZeroArray(int[] nums, int[][] queries) {
		int n = nums.length;
		int[] sum = new int[n + 1];
		for (int i = 0; i < queries.length; i++) {
			sum[queries[i][0]]++;
			sum[queries[i][1]+1]--;
		}

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + sum[i];
		}

		for (int i = 0; i < n; i++) {
			if (sum[i] < nums[i]) {
				return false;
			}
		}
		return true;
	}
}
