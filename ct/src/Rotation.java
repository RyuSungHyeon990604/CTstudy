import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotation {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = columns*i + j+1;
            }
        }

        int idx = 0;
        for(int[] querie : queries){
            int x1 = querie[0]-1;
            int y1 = querie[1]-1;
            int x2 = querie[2]-1;
            int y2 = querie[3]-1;
            int min = map[x1][y1];
            int tmp  = map[x1+1][y1];

            for (int i = y1 ; i < y2; i++) {
               if(tmp != map[x1][i]){
                   int a = map[x1][i];
                   map[x1][i] = tmp;
                   tmp = a;
               }
                if(min > map[x1][i]){
                    min = map[x1][i];
                }
            }
            for (int i = x1 ; i < x2; i++) {
                if(tmp != map[i][y2]){
                    int a = map[i][y2];
                    map[i][y2] = tmp;
                    tmp = a;
                }
                if(min > map[i][y2]){
                    min = map[i][y2];
                }
            }
            for (int i = y2 ; i > y1 ; i--){
                if(tmp != map[x2][i]){
                    int a = map[x2][i];
                    map[x2][i] = tmp;
                    tmp = a;
                }
                if(min > map[x2][i]){
                    min = map[x2][i];
                }
            }
            for (int i = x2 ; i > x1; i--) {
                if(tmp != map[i][y1]){
                    int a = map[i][y1];
                    map[i][y1] = tmp;
                    tmp = a;
                }
                if(min > map[i][y1]){
                    min = map[i][y1];
                }
            }
            answer[idx] = min;
            idx ++;
        }


        return answer;
    }
}
