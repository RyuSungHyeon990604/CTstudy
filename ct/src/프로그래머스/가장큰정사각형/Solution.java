package 프로그래머스.가장큰정사각형;

public class Solution {
	public int solution(int [][]board) {
		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1 && i > 0 && j > 0){
					int s = Math.min(Math.min(board[i-1][j-1], board[i][j-1]), board[i-1][j]);
					if(s == 0)
						continue;
					board[i][j] = s+1;
				}
				if(board[i][j] > max)
					max = board[i][j];
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][]{{1,0},{0,1}});
	}
}
