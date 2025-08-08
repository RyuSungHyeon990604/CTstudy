package LEETCODE.SoupServings;

public class Solution {
	private final int[][] operations = {{4, 0},{3, 1}, {2, 2}, {1, 3}};
	public double soupServings(int n) {
		//A의 평균 감소율이 B보다 크기때문에 n의 크기가 클수록 1에 수렴
		if(n >= 5000) return 1;
		int divided25 = (int) Math.ceil(n / 25.0);
		Double[][] map = new Double[divided25+1][divided25+1];
		return dfs(divided25, divided25, map);
	}

	public double dfs(int a, int b, Double[][] map) {
		if(a <= 0 && b <= 0) {
			return 0.5;
		}
		if(a <= 0) {
			return 1;
		}
		if(b <= 0) {
			return 0;
		}
		if(map[a][b] != null) {
			return map[a][b];
		}

		double total = 0.0;
		for (int i = 0 ; i < operations.length ; i++) {
			total += dfs(a-operations[i][0], b-operations[i][1], map);
		}
		total *= 0.25;
		map[a][b] = total;

		return total;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		double v = s.soupServings(5000);
		System.out.println("v = " + v);
	}
}
