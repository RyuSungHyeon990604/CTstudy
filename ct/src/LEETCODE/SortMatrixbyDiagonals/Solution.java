package LEETCODE.SortMatrixbyDiagonals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int[][] sortMatrix(int[][] grid) {
		int[][] res = new int[grid.length][grid[0].length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < grid.length; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = grid.length-1; i >= 0; i--) {
			int x = i;
			int y = 0;
			List<Integer> t = new ArrayList<>();
			while(isValid(x,y,grid)) {
				t.add(grid[x][y]);
				x++;
				y++;
			}
			Collections.sort(t);

			for (int j = i ; j < grid.length; j++) {
				list.get(j).add(t.get(t.size()-1-(j-i)));
			}
		}

		for (int i = 1; i < grid[0].length; i++) {
			int x = 0;
			int y = i;
			List<Integer> t = new ArrayList<>();
			while(isValid(x,y,grid)) {
				t.add(grid[x][y]);
				x++;
				y++;
			}
			Collections.sort(t);

			for (int j = 0; j < t.size(); j++) {
				list.get(j).add(t.get(j));
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				res[i][j] = list.get(i).get(j);
			}
		}
		return res;
	}

	private boolean isValid(int row, int col, int[][] grid) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
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
