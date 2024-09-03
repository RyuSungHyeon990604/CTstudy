import java.util.Arrays;
import java.util.Comparator;

public class TableHash {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[col-1] == b[col-1])
                    return b[0] - a[0];
                else
                    return a[col-1] - b[col-1];
            }
        });
        for (int i = row_begin - 1; i < row_end; i++) {
            int si = 0;
            for (int j = 0; j < data[i].length; j++) {
                si += data[i][j] % (i+1);
            }
            if( i == row_begin - 1 ){
                answer = si;
            }else{
                answer = answer ^ si;
            }
        }
        return answer;
    }
}
