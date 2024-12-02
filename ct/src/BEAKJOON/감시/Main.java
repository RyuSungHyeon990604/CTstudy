package BEAKJOON.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int blank = 0;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        printMinimumSizeOfBlindSpot(map,m,n);
    }

    private static void printMinimumSizeOfBlindSpot(int[][] map,int m,int n) {

        List<int[]> cctvs = new ArrayList<>();
        List<Integer> types = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    blank++;
                }else{
                    if(map[i][j] != 6){
                        cctvs.add(new int[]{i,j});
                        types.add(map[i][j]);
                    }
                }
            }
        }

        dfs(map,cctvs,types,0,0);

        System.out.println(answer);
    }

    public static void dfs(int[][] map, List<int[]> cctvs, List<Integer> types,int depth,int observedCnt){
        if(depth == cctvs.size()){
            answer = Math.min(answer,blank - observedCnt);
            return;
        }

        int[] cctvPosition = cctvs.get(depth);
        int type = types.get(depth);
        int row = cctvPosition[0], col = cctvPosition[1];

        for(int[] dir : typeOfDirections(type)){
            int observe = observe(dir[0], dir[1], dir[2], dir[3], row, col, map, true);
            dfs(map,cctvs,types,depth+1,observedCnt+observe);
            observe(dir[0], dir[1], dir[2], dir[3], row, col, map, false);
        }
    }
    public static List<int[]> typeOfDirections(int type){
        List<int[]> dirs = new ArrayList<>();
        if(type == 1){
            dirs.add(new int[]{1,0,0,0});
            dirs.add(new int[]{0,1,0,0});
            dirs.add(new int[]{0,0,1,0});
            dirs.add(new int[]{0,0,0,1});
        }else if(type == 2){
            dirs.add(new int[]{1,1,0,0});
            dirs.add(new int[]{0,0,1,1});
        }else if(type == 3){
            dirs.add(new int[]{1,0,1,0});
            dirs.add(new int[]{1,0,0,1});
            dirs.add(new int[]{0,1,1,0});
            dirs.add(new int[]{0,1,0,1});
        }else if(type == 4){
            dirs.add(new int[]{1,1,1,0});
            dirs.add(new int[]{1,1,0,1});
            dirs.add(new int[]{1,0,1,1});
            dirs.add(new int[]{0,1,1,1});
        }else if(type == 5){
            dirs.add(new int[]{1,1,1,1});
        }
        return dirs;
    }
    public static int observe(int up,int down,int left,int right,int row, int col, int[][] map,boolean flag){
        int observedCnt = 0;
        if(up == 1){
            for(int i = row-1; i >= 0; i--){
                if(map[i][col] == 6){
                    break;
                }
                if(flag){
                    if(map[i][col] <= 0){
                        if(map[i][col] == 0)
                            observedCnt++;
                        map[i][col] -= 1;
                    }
                }else{
                    if(map[i][col] < 0){
                        map[i][col] += 1;
                    }
                }

            }
        }
        if(down == 1){
            for(int i = row+1; i < map.length; i++){
                if(map[i][col] == 6){
                    break;
                }
                if(flag){
                    if(map[i][col] <= 0){
                        if(map[i][col] == 0)
                            observedCnt++;
                        map[i][col] -= 1;
                    }
                }else{
                    if(map[i][col]  < 0){
                        map[i][col] += 1;
                    }
                }
            }
        }
        if(left == 1){
            for(int i = col-1; i >= 0; i--){
                if(map[row][i] == 6){
                    break;
                }
                if(flag){
                    if(map[row][i] <= 0){
                        if(map[row][i] == 0)
                            observedCnt++;
                        map[row][i] -= 1;
                    }
                }else{
                    if(map[row][i]  < 0){
                        map[row][i] += 1;
                    }
                }

            }
        }
        if(right == 1){
            for(int i = col+1; i < map[0].length; i++){
                if(map[row][i] == 6){
                    break;
                }
                if(flag){
                    if(map[row][i] <= 0){
                        if(map[row][i] == 0)
                            observedCnt++;
                        map[row][i] -= 1;
                    }
                }else{
                    if(map[row][i]  < 0){
                        map[row][i] += 1;
                    }
                }
            }
        }

        return observedCnt;
    }
}
