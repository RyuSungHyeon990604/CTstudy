package LEETCODE.MaximumDifferenceBetweenIncreasingElements;

public class Solution {
	public int maximumDifference(int[] nums) {
		int diff = Integer.MIN_VALUE;
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > min) {
				diff = Math.max(diff, nums[i] - min);
			}
			min = Math.min(min, nums[i]);
		}

		return diff <= 0 ? -1 : diff;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.maximumDifference(new int[]{7,1,5,4});
	}
}
