import java.util.*;

public class PillarAndWeir {
    /*
     n*n
     build_frame[i] = [x,y,a,b]
     a : 기둥(0) , 보(1)
     b : 삭제(0) , 설치(1)
     */
    public int[][] solution(int n, int[][] build_frame) {
        int[][] pillar = new int[n + 1][n + 1];
        int[][] weir = new int[n + 1][n + 1];
        for (int[] order : build_frame) {
            int x = order[0];
            int y = order[1];
            int tp = order[2];
            int delOrCre = order[3];
            if (delOrCre == 1) {
                create(x, y, pillar, weir, tp, n);
            } else {
                delete2(x, y, pillar, weir, tp, n);
            }
        }
        return asToArray(pillar, weir, n);
    }

    public int[][] asToArray(int[][] pillar, int[][] weir, int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j] == 1) {
                    list.add(new int[]{i, j, 0});
                }
                if (weir[i][j] == 1) {
                    list.add(new int[]{i, j, 1});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void create(int x, int y, int[][] pillar, int[][] weir, int tp, int n) {
        if (tp == 0) {//create pillar
            if (pillarIsValid(x,y,pillar,weir,n)) {
                pillar[x][y] = 1;
            }
        } else {//create weir
            if (weirIsValid(x,y,pillar,weir,n)) {
                weir[x][y] = 1;
            }
        }
    }
    public boolean pillarIsValid(int x, int y, int[][] pillar,int[][] weir,int n) {
        if(x < 0 || x > n || y < 0 || y > n ) return false;
        return y == 0 //바닥이거나
                || (x > 0 && weir[x - 1][y] == 1) // 왼쪽보 위
                || weir[x][y] == 1 //오른쪽 보 위
                || pillar[x][y - 1] == 1;// 기둥 위거나
    }
    public boolean weirIsValid(int x, int y, int[][] pillar,int[][] weir,int n) {
        if(x < 0 || x > n || y< 0 || y > n ) return false;
        return pillar[x][y - 1] == 1 //한쪽면이 기둥과 걸쳐있거나
                || (x < n && pillar[x + 1][y - 1] == 1) //한쪽면이 기둥과 걸쳐있거나
                || ((x > 0 && weir[x-1][y] == 1) && (x < n && weir[x+1][y] == 1)); //양쪽전부 보에 걸쳐있을때
    }
    public boolean valid(int[][] pillar,int[][] weir,int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j] == 1) {
                    if (!pillarIsValid(i,j,pillar,weir,n)) { // 다른 기둥 위
                        return false;
                    }
                }
                if (weir[i][j] == 1) {
                    if (!weirIsValid(i,j,pillar,weir,n)) { // 양쪽 끝이 다른 보와 연결
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void delete2(int x, int y, int[][] pillar, int[][] weir, int tp, int n) {
        if(tp == 0) {
            pillar[x][y] = 0;
            if(!valid(pillar,weir,n)) {
                pillar[x][y] = 1;
            }
        }else{
            weir[x][y] = 0 ;
            if(!valid(pillar,weir,n)) {
                weir[x][y] = 1;
            }

        }
    }
    public static void main(String[] args) {
        PillarAndWeir p = new PillarAndWeir();
        p.solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
    }

}
