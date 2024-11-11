public class Change {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % 1_000_000_007;
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        Change c = new Change();
        int solution = c.solution(4, new int[]{1, 2, 5});
        System.out.println("solution = " + solution);
    }
}
