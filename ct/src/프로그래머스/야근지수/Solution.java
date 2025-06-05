package 프로그래머스.야근지수;
import java.util.TreeMap;

public class Solution {
	private final int MAX_SIZE = 50001;
	//야근 피로도 += 야근을 시작한 시점에서 남은 일의 작업량 ^ 2
	public long solution(int n, int[] works) {
		long answer = 0;
		int[] arr = new int[MAX_SIZE];
		int max = -1;
		for (int work : works) {
			arr[work]++;
			max = Math.max(max, work);
		}

		for (int i = max; i > 0 && n > 0; i--) {
			if(arr[i] > n) {
				arr[i-1] += n;
				arr[i] = arr[i] - n;
				n = 0;
			} else {
				max = i - 1;
				arr[i-1] += arr[i];
				n -= arr[i];
			}
		}

		for (int i = 0; i <= max; i++) {
			answer += arr[i] * ((long) i * i);
		}



		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		long solution1 = solution.solution(1, new int[]{2, 1,2});
		System.out.println("solution1 = " + solution1);
	}
}
