import java.util.*;

public class Island {
    public int[] solution(String[] maps) {
        int[] answer = {};
        int c = 0;
        int[][] map = new int[maps.length][maps[0].length()];
        int[] sum = new int[maps.length*maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
           for (int j = 0; j < maps[i].length(); j++) {
               if (maps[i].charAt(j) == 'X') {
                map[i][j] = 0;
               }else
                map[i][j] = maps[i].charAt(j) - '0';
           }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j]!=0) {
                    search(map,i,j,sum,c);
                    c++;
                }
            }
        }
        if(c <= 0){
            answer =new int[]{-1};
        }else{
            answer = Arrays.copyOfRange(sum, 0, c);
            Arrays.sort(answer);
        }
        return answer;

    }

    public void search(int[][] map,int x, int y,int[] sum,int c){
        if(x < 0 || x>= map.length){
            return;
        }
        if(y < 0 || y>= map[0].length){
            return;
        }

        if(map[x][y] != 0){
            sum[c] += map[x][y];
            map[x][y] = 0;
            search(map,x,y+1,sum,c);
            search(map,x,y-1,sum,c);
            search(map,x+1,y,sum,c);
            search(map,x-1,y,sum,c);
        }
    }
}
