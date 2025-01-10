package 프로그래머스.리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dirRow = {1, 0, -1, 0};
    int[] dirCol = {0, -1, 0, 1};
    public int solution(String[] board) {
        char[][] boardC = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            boardC[i] = board[i].toCharArray();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (boardC[i][j] == 'R') {
                    return bfs(boardC, i, j);
                }
            }
        }
        return -1;
    }
    public int bfs(char[][] boardC,int x,int y) {
        boolean[][] visited = new boolean[boardC.length][boardC[0].length];
        int m = boardC.length;
        int n = boardC[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if(boardC[cur[0]][cur[1]] == 'G') {
                    return step;
                }
                for (int k = 0; k < 4; k++) {
                    int row = cur[0];
                    int col = cur[1];
                    while (isValid(m,n,row+dirRow[k],col+dirCol[k]) &&  boardC[row+dirRow[k]][col+dirCol[k]] != 'D') {
                        row+=dirRow[k];
                        col+=dirCol[k];
                    }
                    if(!visited[row][col]) {
                        visited[row][col] = true;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public boolean isValid(int m,int n,int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
    }
}
