//가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.


import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public int answer=0;
    public int solution(int n) {
        // n<=12
        //각 열에 하나씩 있어야함
        //그리고 열의 차이만큼 수평거리가 있어야함
        //첫번째 q의 위치를 기준으로 아래쪽의 q의 위치를 맞춰나가자
        int [] board = new int[n];
        solve(0,board,n);

        return answer;
    }

    /*
    * x : 윗 행의 x좌표
    * y : 윗 행의 y좌표
    * */
    public void solve(int row, int[] board,int n){
        //1 차원 배열로표현
        //index 가 x ,  value가 y
        if(row >= n){
            return;
        }
        for(int i = 0 ; i < n ; i++){
            board[row] = i;
            if(chkBoard(board, row)){
                if(row == n-1){
                    answer++;
                    return;
                }
                solve(row+1,board,n);
            }
        }
    }

    public boolean chkBoard(int[] board,int row){
        boolean flag= true;
        for(int i = 0 ;i<row ;i++){
            if(i == row || board[i] == board[row]){
                flag = false;
            }
            if(Math.abs(board[i]-board[row]) == Math.abs(i-row))
                flag =  false;
        }
        return flag;
    }
}
