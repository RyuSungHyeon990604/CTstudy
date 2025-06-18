package 프로그래머스.거리두기확인하기;

import java.util.Arrays;

public class Solution {
	private final char APPLICANT = 'P';
	private final char EMPTY_TABLE = 'O';
	private final int[] dirX = {1,-1,0,0};
	private final int[] dirY = {0,0,1,-1};
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		Arrays.fill(answer, -1);

		for (int i = 0; i < places.length; i++) {
			if (checkRoom(places[i])) {
				answer[i] = 0;
			} else
				answer[i] = 1;
		}

		return answer;
	}

	private boolean checkRoom(String[] room) {
		char[][] grid = new char[room.length][room[0].length()];
		for (int i = 0; i < room.length; i++) {
			grid[i] = room[i].toCharArray();
		}

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == EMPTY_TABLE && hasDoubleApplicant(grid, row, col))
					return true;

				if(grid[row][col] == APPLICANT && hasCloseApplicant(grid, row, col))
					return true;
			}
		}
		return false;
	}

	private boolean hasCloseApplicant(char[][] grid, int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nr = row + dirX[i];
			int nc = col + dirY[i];
			if(isAvailable(grid, nr, nc) && grid[nr][nc] == APPLICANT) return true;
		}
		return false;
	}

	private boolean hasDoubleApplicant(char[][] grid, int row, int col) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + dirX[i];
			int nc = col + dirY[i];
			if(isAvailable(grid, nr, nc) && grid[nr][nc] == APPLICANT) cnt++;
			if(cnt == 2) return true;
		}
		return false;
	}

	public boolean isAvailable(char[][] grid, int row, int col) {
		return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
	}
}
