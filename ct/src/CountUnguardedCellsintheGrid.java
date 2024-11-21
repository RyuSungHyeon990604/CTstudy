public class CountUnguardedCellsintheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map = new int[m][n];
        for (int[] wall : walls) {
            map[wall[0]][wall[1]] = 2;
        }
        int count = 0;
        for (int[] guard : guards) {
            if(map[guard[0]][guard[1]] != 1) {
                map[guard[0]][guard[1]] = 1;
                count++;
            }
            if(m!=1){
                for (int x = guard[0]+1; x < m; x++) {
                    if(n == 1 && map[x][guard[1]] == 1) break;
                    if(map[x][guard[1]] == 2) break;
                    if(map[x][guard[1]] == 1) continue;
                    map[x][guard[1]] = 1;
                    count++;
                }
                for (int x = guard[0]-1; x >= 0; x--) {
                    if(n == 1 && map[x][guard[1]] == 1) break;
                    if(map[x][guard[1]] == 2) break;
                    if(map[x][guard[1]] == 1) continue;
                    map[x][guard[1]] = 1;
                    count++;
                }
            }
            if(n != 1){
                for (int y = guard[1]+1; y < n; y++) {
                    if(m == 1 && map[guard[0]][y] == 1) break;
                    if(map[guard[0]][y] == 2) break;
                    if(map[guard[0]][y] == 1) continue;
                    map[guard[0]][y] = 1;
                    count++;
                }
                for (int y = guard[1]-1; y >= 0; y--) {
                    if(m == 1 && map[guard[0]][y] == 1) break;
                    if(map[guard[0]][y] == 2) break;
                    if(map[guard[0]][y] == 1) continue;
                    map[guard[0]][y] = 1;
                    count++;
                }
            }

        }
        return m*n -count-walls.length;
    }

    public static void main(String[] args) {
        CountUnguardedCellsintheGrid c = new CountUnguardedCellsintheGrid();
        c.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}});
    }

}
