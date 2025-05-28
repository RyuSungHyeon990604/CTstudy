package 프로그래머스.블록이동하기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private final int[] dirX = {-1, 1, 0, 0};
	private final int[] dirY = {0, 0, -1, 1};
	public int solution(int[][] board) {
		int answer = 0;
		int[][][][] visited = new int[board.length][board[0].length][board.length][board[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0,0,1});

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();

				if((cur[0] == board.length-1 && cur[1] == board[0].length-1)
					|| (cur[2] == board.length-1 && cur[3] == board[0].length-1)
				) {
					return answer;
				}

				// 4방향이동
				for (int k = 0; k < 4; k++) {
					int x1 = cur[0] + dirX[k];
					int y1 = cur[1] + dirY[k];
					int x2 = cur[2] + dirX[k];
					int y2 = cur[3] + dirY[k];
					if(canMove(board, x1, y1) && canMove(board, x2, y2)) {
						if(visited[x1][y1][x2][y2] == 0 || visited[x2][y2][x1][y1] == 0) {
							visited[x1][y1][x2][y2]=1;
							visited[x2][y2][x1][y1]=1;
							queue.offer(new int[]{x1, y1, x2, y2});
						}
					}
				}

				//회전
				if (cur[0] == cur[2]) { // 가로 상태
					int x = cur[0];
					for (int d = -1; d <= 1; d += 2) { // 위(-1), 아래(+1)
						int nx = x + d;
						if (canMove(board, nx, cur[1]) && canMove(board, nx, cur[3])) {

							// 왼쪽 좌표를 축으로 회전
							if (visited[cur[0]][cur[1]][nx][cur[1]] == 0) {
								visited[cur[0]][cur[1]][nx][cur[1]] = 1;
								visited[nx][cur[1]][cur[0]][cur[1]] = 1;
								queue.offer(new int[]{cur[0], cur[1], nx, cur[1]});
							}

							// 오른쪽 좌표를 축으로 회전
							if (visited[cur[2]][cur[3]][nx][cur[3]] == 0) {
								visited[cur[2]][cur[3]][nx][cur[3]] = 1;
								visited[nx][cur[3]][cur[2]][cur[3]] = 1;
								queue.offer(new int[]{cur[2], cur[3], nx, cur[3]});
							}
						}
					}
				}

				if (cur[1] == cur[3]) { // 세로 상태
					int y = cur[1];
					for (int d = -1; d <= 1; d += 2) { // 좌(-1), 우(+1)
						int ny = y + d;
						if (canMove(board, cur[0], ny) && canMove(board, cur[2], ny)) {

							// 위쪽 좌표를 축으로 회전
							if (visited[cur[0]][cur[1]][cur[0]][ny] == 0) {
								visited[cur[0]][cur[1]][cur[0]][ny] = 1;
								visited[cur[0]][ny][cur[0]][cur[1]] = 1;
								queue.offer(new int[]{cur[0], cur[1], cur[0], ny});
							}

							// 아래쪽 좌표를 축으로 회전
							if (visited[cur[2]][cur[3]][cur[2]][ny] == 0) {
								visited[cur[2]][cur[3]][cur[2]][ny] = 1;
								visited[cur[2]][ny][cur[2]][cur[3]] = 1;
								queue.offer(new int[]{cur[2], cur[3], cur[2], ny});
							}
						}
					}
				}
			}
			answer++;
		}
		return answer;
	}
	public boolean canMove(int[][] board, int x1, int y1) {
		return x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && board[x1][y1] == 0;
	}

}
