public class TicTacToe {
    public int solution(String[] board) {
        return chk1(board);
    }

    public int chk1(String[] board) {
        int countO = 0;
        int countX = 0;
        int bingGoO = 0;
        int bingGoX = 0;
        for (String r : board) {
            for (int i = 0; i < r.length(); i++) {
                if (r.charAt(i) == 'O') {
                    countO++;
                }
                if (r.charAt(i) == 'X') {
                    countX++;
                }
            }
        }
        bingGoO = chkBingGo(board,'O');
        bingGoX = chkBingGo(board,'X');
        if(bingGoO > 0 && bingGoX >0){//둘다 빙고가 나올수없다.
            return 0;
        }
        if(bingGoO >= 1){
            if(countO != countX+1)
                return 0;
        }
        if(bingGoX>= 1){
            if(countX != countO || countO > countX)
                return 0;
        }

        if((countX + countO) == 9){
            if(countO != 5)
                return 0;
        }else{
            if((countO - countX) > 1 || countX > countO)
                return 0;
        }

        return 1;
    }

    public int chkBingGo(String[] board,char c){
        int count = 0;
        if(c == 'O'){
            for (String r : board) {
                if(r.equals("OOO")){
                    count++;
                }
            }
            for (int i =0 ; i < 3 ;i++){
                if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O'&&board[2].charAt(i) == 'O' ){
                    count++;
                }
            }
            if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O' ){
                count++;
            }
            if(board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O' ){
                count++;
            }
        } else if (c =='X') {
            for (String r : board) {
                if(r.equals("XXX")){
                    count++;
                }
            }
            for (int i =0 ; i < 3 ;i++){
                if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X' ){
                    count++;
                }
            }
            if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X' ){
                count++;
            }
            if(board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X' ){
                count++;
            }
        }


        return count;
    }
}
