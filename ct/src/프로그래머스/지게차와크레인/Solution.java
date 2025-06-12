package 프로그래머스.지게차와크레인;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	private final int[] dirX = {1, -1, 0, 0};
	private final int[] dirY = {0, 0, 1, -1};
	private char[][] chars;

	public int solution(String[] storage, String[] requests) {
		int n = storage.length;
		int m = storage[0].length();
		chars = new char[n][m];
		for (int i = 0; i < n; i++) {
			chars[i] = storage[i].toCharArray();
		}
		int removed = 0;
		for (String request : requests) {
			char c = request.charAt(0);
			if(request.length() == 1) {
				removed += removeByForkLift(c);
			} else {
				removed += removeByCrane(c);
			}
		}

		return n * m - removed;
	}

	private int removeByForkLift(char target) {
		List<int[]> positions = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[0].length; j++) {
				if (chars[i][j] == target) {
					if (isOut(i, j)) {
						positions.add(new int[]{i, j});
					}
				}
			}
		}

		positions.forEach(position -> {
			chars[position[0]][position[1]] = ' ';
		});
		return positions.size();
	}

	private int removeByCrane(char target) {
		int removed = 0;
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[0].length; j++) {
				if (chars[i][j] == target) {
					chars[i][j] = ' ';
					removed++;
				}
			}
		}
		return removed;
	}

	private boolean isOut(int x, int y) {
		if (isOutSide(x, y)) {
			return true;
		}
		boolean[][] vis = new boolean[chars.length][chars[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		vis[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dirX[i];
				int ny = cur[1] + dirY[i];

				if (nx < 0 || ny < 0 || nx >= chars.length || ny >= chars[0].length || vis[nx][ny]) {
					continue;
				}

				if (chars[nx][ny] == ' ') {
					if (isOutSide(nx, ny)) {
						return true;
					}
					vis[nx][ny] = true;
					queue.add(new int[]{nx, ny});
				}
			}
		}
		return false;
	}

	public boolean isOutSide(int x, int y) {
		return x == 0 || x == chars.length - 1 || y == 0 || y == chars[0].length - 1;
	}

}
