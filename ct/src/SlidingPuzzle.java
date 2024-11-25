import java.util.*;
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        StringBuilder str = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
            }
        }
        //0의 위치마다 바꿀수있는 자리들
        int[][] swapTargets = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {4, 2},};
        int count = 0;
        queue.add(str.toString());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(poll.equals("123450")){
                    return count;
                }
                int zeroIndex = poll.indexOf("0");
                for (int swapTarget : swapTargets[zeroIndex]){
                    StringBuilder nStr = new StringBuilder(poll);
                    nStr.setCharAt(zeroIndex, nStr.charAt(swapTarget));
                    nStr.setCharAt(swapTarget, '0');
                    if(vis.add(nStr.toString())){
                        queue.offer(nStr.toString());
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
