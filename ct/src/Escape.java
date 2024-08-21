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
        int[][] visit = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if(map[i][j] == 'S') {
                    findL(map, i, j, 0,visit);
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

    public void findL(char[][] map, int x,int y,int depth,int[][] visit){
        if(x < 0 || x > map.length-1 || y < 0 || y > map[0].length-1){
            return;
        }
        if(map[x][y] == 'X') return;
        if(map[x][y] == 'L'){
            if (l == -1){
                lX = x;
                lY =y;
                l = depth;
            }
            if(l != -1 && l > depth){
                lX = x;
                lY =y;
                l = depth;
            }
            return;
        }
        if(visit[x][y] == 0){
            visit[x][y] = 1;
            findL(map, x, y-1, depth+1,visit);
            findL(map, x+1, y, depth+1,visit);
            findL(map, x-1, y, depth+1,visit);
            findL(map, x, y+1, depth+1,visit);
            visit[x][y] = 0; //방문처리 해제(백트래킹) : 존나중요함
        }
        return;
    }
    public void findS(char[][] map, int x,int y,int depth){
        if(x < 0 || x > map.length-1 || y < 0 || y > map[0].length-1){
            return;
        }
        if(map[x][y] == 'X') return;
        if(map[x][y] == 'E'){
            if (s == -1){
                s = depth;
            }
            if(s != -1 && s > depth){
                s = depth;
            }
            return;
        }

        map[x][y] = 'X';
        findS(map, x, y+1, depth+1);
        findS(map, x+1, y, depth+1);
        findS(map, x, y-1, depth+1);
        findS(map, x-1, y, depth+1);


    }
}
