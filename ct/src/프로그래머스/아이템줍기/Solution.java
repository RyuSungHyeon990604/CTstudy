package 프로그래머스.아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private final int LIMIT = 50;
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		int[][] grid = new int[LIMIT*2+1][LIMIT*2+1];
		for (int[] range : rectangle) {
			fillGrid(grid, range);
		}
		return bfs(grid, characterX, characterY, itemX, itemY);
	}

	private void fillGrid(int[][] grid, int[] range) {
		int leftBottomX = range[0]*2;
		int leftBottomY = range[1]*2;
		int rightTopX = range[2]*2;
		int rightTopY = range[3]*2;
		for (int row = leftBottomX; row <= rightTopX; row++) {
			for (int col = leftBottomY; col <= rightTopY; col++) {
				if(row == leftBottomX || row == rightTopX || col == leftBottomY || col == rightTopY) {
					if(grid[row][col] != 2) {
						grid[row][col] = 1;
					}
				} else {
					grid[row][col] = 2;
				}
			}
		}
	}

	private int bfs(int[][] grid, int startX, int startY, int endX, int endY) {
		boolean[][] vis = new boolean[grid.length][grid[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX*2, startY*2, 0});
		int[] dirX = new int[]{-1, 1, 0, 0};
		int[] dirY = new int[]{0, 0, -1, 1};
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0] == endX*2 && cur[1] == endY*2) {
				return cur[2] / 2;
			}
			for (int k = 0; k < 4; k++) {
				int x = cur[0] + dirX[k];
				int y = cur[1] + dirY[k];
				if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
					if(vis[x][y]) continue;
					vis[x][y] = true;
					queue.add(new int[]{x, y, cur[2]+1});
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		//solution.fillGrid(new int[100][100], new int[]{1,1,7,4});
		int solution1 = solution.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7,
			8);
		System.out.println("solution1 = " + solution1);
	}
}
