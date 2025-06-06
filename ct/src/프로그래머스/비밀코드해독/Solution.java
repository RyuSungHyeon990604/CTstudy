package 프로그래머스.비밀코드해독;

public class Solution {
	private int answer = 0;
	public int solution(int n, int[][] q, int[] ans) {
		int[] nums = new int[q.length];
		for (int i = 0; i < q.length; i++) {
			nums[i] = convert(q[i]);
		}
		comb(nums, ans,1, 0, n, 5);
		return answer;
	}

	public void comb(int[] nums, int[] ans, int start, int v, int limit, int remain) {
		if(remain == 0) {
			for (int i = 0; i < nums.length; i++) {
				if(Integer.bitCount(nums[i]&v) != ans[i]) {
					return;
				}
			}
			answer++;
			return;
		}
		for (int i = start; i <= limit; i++) {
			comb(nums, ans, i + 1, v | (1<<i), limit, remain-1);
		}
	}
	public int convert(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = num | (1<<nums[i]);
		}
		return num;
	}
}
