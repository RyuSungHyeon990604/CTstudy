package LEETCODE.SortMatrixbyDiagonals;

import java.util.Arrays;

public class Solution {
	public int[][] sortMatrix(int[][] grid) {
		int[][] res = new  int[grid.length][grid[0].length];

		for (int i = grid.length-1; i >= 0; i--) {
			sortDiagonal(i, 0, grid, res,  true);
		}

		for (int i = 1; i < grid[0].length; i++) {
			sortDiagonal(0, i, grid, res,  false);
		}

		return res;
	}

	private void sortDiagonal(int startX, int startY, int[][] grid, int[][] res, boolean reverse) {
		int x = startX, y = startY;
		int size = Math.min(grid.length - startY, grid[0].length - startX);
		int[] nums = new int[size];

		for (int i = 0; i < size; i++) {
			nums[i] = grid[x++][y++];
		}

		Arrays.sort(nums);
		if(reverse) {
			reversArray(nums);
		}

		for (int i = 0; i < size; i++) {
			res[startX++][startY++] = nums[i];
		}

	}

	private void reversArray(int[] arr) {
		int l = 0, r = arr.length-1;
		while(l < r) {
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr = {
			{1, 7, 3},
			{9, 8, 2},
			{4, 5, 6}
		};
		s.sortMatrix(arr);
	}
}
