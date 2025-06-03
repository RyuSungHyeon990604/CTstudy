package 프로그래머스.최고의집합;

import java.util.Arrays;

public class Solution {
	public int[] solution(int n, int s) {
		if(n>s) return new int[]{-1};
		int[] answer = new int[n];
		Arrays.fill(answer, s / n);
		int remain = s % n;
		for (int i = n - 1; remain > 0; i--) {
			answer[i] = answer[i] + 1;
			remain--;
		}
		return answer;
	}
}
