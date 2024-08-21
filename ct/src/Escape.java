import java.util.LinkedList;
import java.util.Queue;

public class Escape {

    //S : 시작 지점
    //E : 출구
    //L : 레버
    //O : 통로
    //X : 벽
    public int l = -1;
    public int s = -2;
    public int lX;
    public int lY;

    public int solution(String[] maps) {
        int answer = -1;
        char[][] map  = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if(map[i][j] == 'S') {
                    findL(map, i, j, 0);
                    if(l == -1){
                        s = -1;
                        break;
                    }else{
                        s = -1;
                        findS(map, lX, lY, 0);
                    }
                    break;
                }
            }
            if(s != -2){
                break;
            }

        }
        if(l != -1 && s != -1){
            answer = l + s;
        }
        return answer;
    }

    public void findL(char[][] map, int x,int y,int depth){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int [][] vis = new int[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y,depth});
        vis[x][y] = 1;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int lx = arr[0];
            int ly = arr[1];
            int d = arr[2];

            if(map[lx][ly] == 'L'){
                l = d;
                lX = lx;
                lY = ly;
                break;
            }
            for(int i = 0; i < dir.length; i++) {
                int newX = lx + dir[i][0];
                int newY = ly + dir[i][1];
                if(newX >= 0 && newX < map.length && newY >= 0 && newY<map[0].length && vis[newX][newY] == 0){
                    if(map[newX][newY] != 'X'){
                        vis[newX][newY] = 1;
                        q.add(new int[]{newX, newY, d+1});
                    }
                }
            }
        }
    }
    public void findS(char[][] map, int x,int y,int depth){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int [][] vis = new int[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y,depth});
        map[x][y] = 'X';
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int lx = arr[0];
            int ly = arr[1];
            int d = arr[2];

            if(map[lx][ly] == 'E'){
                s = d;
                break;
            }
            for(int i = 0; i < dir.length; i++) {
                int newX = lx + dir[i][0];
                int newY = ly + dir[i][1];
                if(newX >= 0 && newX < map.length && newY >= 0 && newY<map[0].length && vis[newX][newY] == 0){
                    if(map[newX][newY] != 'X'){
                        vis[newX][newY] = 1;
                        q.add(new int[]{newX, newY, d+1});
                    }
                }
            }
        }


    }
}
