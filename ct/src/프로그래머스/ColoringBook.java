import java.util.PriorityQueue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int[][] vis = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if(vis[i][j] == 0 && picture[i][j]!= 0 ) {
                    int[] t= new int[]{picture[i][j],0};
                    dfs(picture,i,j,vis,t);
                    pq.add(t);
                }
            }
        }
        if(pq.isEmpty())
            return new int[]{0,0};
        return new int[]{pq.size(), pq.poll()[1]};
    }

    public void dfs(int[][] picture,int x,int y,int[][] vis,int[] count){
        if(x < 0 || x > picture.length-1 || y < 0 || y > picture[0].length-1) return;
        if(vis[x][y] == 1) return;
        if(picture[x][y] != count[0] ) return;

        vis[x][y] = 1;
        count[1]++;
        dfs(picture,x+1,y,vis,count);
        dfs(picture,x,y+1,vis,count);
        dfs(picture,x-1,y,vis,count);
        dfs(picture,x,y-1,vis,count);

    }

    public static void main(String[] args) {
        ColoringBook cb = new ColoringBook();
        cb.solution(6,4,new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }
}
