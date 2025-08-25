package LEETCODE.DiagonalTraverse;

public class Solution {
	class Node {
		int x, y;
		boolean up;
		final int[][] mat;

		Node(int x, int y, int[][] mat) {
			this.x = x;
			this.y = y;
			this.mat = mat;
			this.up = true;
		}

		// 다음 좌표로 이동
		void next() {
			// 1) 대각선 진행, 2) 경계에 닿았을 때 보정 이동(두 가지)
			int[][] candidates = up
				? new int[][]{ {x - 1, y + 1}, {x, y + 1}, {x + 1, y} }   // 위, 우, 하
				: new int[][]{ {x + 1, y - 1}, {x + 1, y}, {x, y + 1} };  // 아래, 하, 우

			if (inBounds(candidates[0][0], candidates[0][1])) {
				x = candidates[0][0];
				y = candidates[0][1];
				return;
			}

			up = !up;
			for (int i = 1; i < candidates.length; i++) {
				int nx = candidates[i][0], ny = candidates[i][1];
				if (inBounds(nx, ny)) {
					x = nx; y = ny;
					return;
				}
			}

			// 이동 불가
			x = -1; y = -1;
		}

		boolean inBounds(int nx, int ny) {
			return nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length;
		}

		boolean isValid() {
			return x >= 0 && y >= 0;
		}
	}
	public int[] findDiagonalOrder(int[][] mat) {
		int n = mat.length, m = mat[0].length;
		int[] res = new int[n * m];
		Node cur = new Node(0, 0, mat);

		int i = 0;
		while (cur.isValid() && i < res.length) {
			res[i++] = mat[cur.x][cur.y];
			cur.next();
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] mat =  {
			{1, 2, 3}, {4, 5, 6}, {7, 8, 9}
		};
		Solution s = new Solution();
		int[] diagonalOrder = s.findDiagonalOrder(mat);
		System.out.println("diagonalOrder = " + diagonalOrder);
	}
}
