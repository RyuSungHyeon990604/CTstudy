import javax.print.attribute.standard.OrientationRequested;
import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] h = new boolean[10];
        Arrays.fill(h, true);
        for (int i = 0 ; i < 9 ; i++) { //chkRow
            for (int j = 0 ; j < 9 ; j++) {
                char c = board[i][j];
                if(c <= '9' && c >= '1'){
                    if(!h[c - '0']){
                        return false;
                    }
                    h[c - '0'] = false;
                }
            }
            Arrays.fill(h, true);
        }

        for (int i = 0 ; i < 9 ; i++) { //chkCol
            for (int j = 0 ; j < 9 ; j++) {
                char c = board[j][i];
                if(c <= '9' && c >= '1'){
                    if(!h[c - '0']){
                        return false;
                    }
                    h[c - '0'] = false;
                }
            }
            Arrays.fill(h, true);
        }
        for (int i = 0 ; i < 9 ; i += 3) {
            for (int j = 0 ; j < 9 ; j+=3) {
               for (int a = i ; a < i + 3 ; a++) {
                   for (int b = j ; b < j + 3 ; b++) {
                       char c = board[a][b];
                       if(c <= '9' && c >= '1'){
                           if(!h[c - '0']){
                               return false;
                           }
                           h[c - '0'] = false;
                       }
                   }
               }
               Arrays.fill(h, true);
            }
        }




        return true;
    }


    public static void main(String[] args) {
        char[][] board1 = new char[][]{      {'5','3','.','.','7','.','.','.','.'}
                                            ,{'6','.','.','1','9','5','.','.','.'}
                                            ,{'.','9','8','.','.','.','.','6','.'}
                                            ,{'8','.','.','.','6','.','.','.','3'}
                                            ,{'4','.','.','8','.','3','.','.','1'}
                                            ,{'7','.','.','.','2','.','.','.','6'}
                                            ,{'.','6','.','.','.','.','2','8','.'}
                                            ,{'.','.','.','4','1','9','.','.','5'}
                                            ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = new char[][]{  {'8','3','.','.','7','.','.','.','.'}
                                        ,{'6','.','.','1','9','5','.','.','.'}
                                        ,{'.','9','8','.','.','.','.','6','.'}
                                        ,{'9','.','.','.','6','.','.','.','3'}
                                        ,{'4','.','.','8','.','3','.','.','1'}
                                        ,{'7','.','.','.','2','.','.','.','6'}
                                        ,{'.','6','.','.','.','.','2','8','.'}
                                        ,{'.','.','.','4','1','9','.','.','5'}
                                        ,{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku sudoku = new ValidSudoku();
        
        System.out.println(sudoku.isValidSudoku(board2) ? "True" : "False");

    }
}
