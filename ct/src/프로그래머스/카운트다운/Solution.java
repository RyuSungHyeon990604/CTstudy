package 프로그래머스.카운트다운;

import java.util.Arrays;

public class Solution {

	/***
	 * 과녁 1~20
	 * 더블, 트리플, 불(50), 싱글
	 * <pre>
	 * 승리조건 : 더 많은 싱글, 불 or 선공
	 * </pre>
	 * @param target
	 * @return [던진 다트 수, 싱글 or 불]
	 */
	private final int BOARD_LIMIT = 20;
	private final int BULL = 50;
	private final int DART_IDX = 0;
	private final int SINGLE_BULL_IDX = 1;
	public int[] solution(int target) {
		// 가장 적은 횟수로 다트를 던져야함
		// 가능하다면 싱글, 불을 맞출 것
		if(target <= 20 || target == BULL) return new int[]{1,1};

		int[][] dp = new int[target+1][2];
		for (int i = 1; i <= target; i++) {
			dp[i] = new int[]{1_000_000, 1_000_000};
		}
		int[] scores = getScores();
		for (int score = 1; score <= target; score++) {
			for (int j = 1; j < scores.length; j++) {
				if(scores[j] == -1 || score - j < 0) continue;

				int dartCount = dp[score - j][DART_IDX] + 1;
				int singleBullCount = dp[score - j][SINGLE_BULL_IDX] + scores[j];

				if(dartCount < dp[score][DART_IDX]) {
					dp[score][DART_IDX] = dartCount;
					dp[score][SINGLE_BULL_IDX] = singleBullCount;
				} else if(dartCount == dp[score][DART_IDX]) {
					dp[score][SINGLE_BULL_IDX] = Math.max(dp[score][SINGLE_BULL_IDX], singleBullCount);
				}
			}
		}
		return dp[target];
	}

	private int[] getScores() {
		int[] scores = new int[61];
		Arrays.fill(scores, -1);
		for (int i = 1; i <= BOARD_LIMIT; i++) {
			scores[i] = 1;
			scores[i*2] = 0;
			scores[i*3] = 0;
		}
		scores[BULL] = 1;
		return scores;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(58);
	}
}
