package 프로그래머스.숫자게임;

import java.util.Arrays;

public class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int a = 0;
		int b = 0;
		while (a < A.length && b < B.length) {
			if(A[a] < B[b]) {
				answer++;
				a++;
			}
			b++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
	}
}
