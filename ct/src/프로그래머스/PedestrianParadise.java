public class PedestrianParadise {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        if(m==1 && n == 1) return 1;
        if(m == 2 && n == 1 || m == 1 && n == 2) return 1;
        int[][] r = new int[m][n];
        int[][] d = new int[m][n];
        r[0][0] = 1;
        d[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1 || (i==0 && j ==0)) continue;
                if (cityMap[i][j] == 2) {
                    if (j > 0)
                        r[i][j] = r[i][j - 1];
                    if (i > 0)
                        d[i][j] = d[i - 1][j];
                } else if (cityMap[i][j] == 0) {
                    r[i][j] = ((j>0 ? r[i][j - 1] : 0) + (i>0 ? d[i - 1][j]:0)) % MOD;
                    d[i][j] = ((j>0 ? r[i][j - 1] : 0) + (i>0 ? d[i - 1][j]:0)) % MOD;

                }
            }
        }

        return (r[m - 1][n - 2] + d[m - 2][n - 1]) % MOD;
    }

    public static void main(String[] args) {
        PedestrianParadise p = new PedestrianParadise();
        int solution = p.solution(1, 2, new int[][]{{0, 0}});
        System.out.println("solution = " + solution);
    }
}
