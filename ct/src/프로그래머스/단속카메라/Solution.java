package 프로그래머스.단속카메라;

import java.util.Arrays;

public class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, (a,b)->a[0] - b[0]);
		int answer = 1;
		int pre = routes[0][1];
		for (int i = 1; i < routes.length; i++) {
			if(routes[i][0] > pre) {
				pre = routes[i][1];
				answer++;
			} else {
				pre = Math.min(pre, routes[i][1]);
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][]{{-20,-15}, {-14,-5}, {-18, -13}, {-5,-3}});
	}
}
