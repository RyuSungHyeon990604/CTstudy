package LEETCODE.LengthofLongestVShapedDiagonalSegment;

public class Solution {

	private final int[][] dir = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
	private final int[] rotate = {1, 3, 0, 2};
	private Integer[][][][] memo;
	private int[][] grid;

	public int lenOfVDiagonal(int[][] grid) {
		this.memo = new Integer[grid.length][grid[0].length][dir.length][2];
		this.grid = grid;
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					for (int k = 0; k < dir.length; k++) {
						max = Math.max(max, 1 + dfs(i + dir[k][0], j + dir[k][1], 2, false, k));
					}
				}
			}
		}
		return max;
	}

	public int dfs(int x, int y, int nextV, boolean isRotate, int d) {
		if (!isAvailable(x, y, grid) || grid[x][y] != nextV) {
			return 0;
		}
		if (memo[x][y][d][isRotate ? 1 : 0] != null) {
			return memo[x][y][d][isRotate ? 1 : 0];
		}
		int res = 0;
		res = Math.max(res, dfs(x + dir[d][0], y + dir[d][1], 2 - nextV, isRotate, d) + 1);
		if (!isRotate) {
			int nx = x + dir[rotate[d]][0];
			int ny = y + dir[rotate[d]][1];
			res = Math.max(res, dfs(nx, ny, 2 - nextV, true, rotate[d]) + 1);
		}
		return memo[x][y][d][isRotate ? 1 : 0] = res;
	}

	public boolean isAvailable(int x, int y, int[][] grid) {
		return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{2, 2, 1, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}};

		int[][] grid2 = {
			{1, 1, 1, 2, 0, 0},
			{0, 0, 0, 0, 1, 2}
		};
		System.out.println(s.lenOfVDiagonal(grid2));
	}
}
