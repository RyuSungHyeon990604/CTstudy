package LEETCODE.FindMinimumTimetoReachLastRoom;

import java.util.PriorityQueue;

public class Solution {
	public int minTimeToReach(int[][] moveTime) {
		int[] dirX = {0, 1, 0, -1};
		int[] dirY = {-1, 0, 1, 0};
		int m = moveTime.length;
		int n = moveTime[0].length;
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;

		int[] v = {0, 0, 0};
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		q.offer(v);

		int res = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0], y = poll[1];
			int dis = poll[2];
			if(x == moveTime.length-1 && y == moveTime[0].length-1){
				res = Math.min(res, dis);
				continue;
			}
			if(dis < res) {
				for(int k = 0; k < 4; k++) {
					int nx = x + dirX[k];
					int ny = y + dirY[k];

					if(nx < 0 || ny < 0 || nx >=m || ny >= n) continue;
					if(visited[nx][ny]){
						continue;
					}
					visited[nx][ny] = true;
					if(moveTime[nx][ny] > dis) {
						q.offer(new int[]{nx, ny, moveTime[nx][ny]+1});
					} else {
						q.offer(new int[]{nx, ny, dis+1});
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

	}
}
