package 프로그래머스.광고삽입;

public class Solution {

	public String solution(String play_time, String adv_time, String[] logs) {
		long[] arr = new long[convertTimeToInt(play_time) + 1];
		for (String log : logs) {
			int start = convertTimeToInt(log.split("-")[0]);
			int end = convertTimeToInt(log.split("-")[1]);
			arr[start]++;
			arr[end]--;
		}
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
		int window = convertTimeToInt(adv_time);
		long windowSum = 0;
		for (int i = 0; i < window; i++) {
			windowSum += arr[i];
		}
		long max = windowSum;
		int left = 0;
		int right = window;
		int result = 0;
		while (right < arr.length) {
			windowSum = windowSum - arr[left++] + arr[right++];
			if (windowSum > max) {
				max = windowSum;
				result = left;
			}
		}
		return convertIntToTime(result);
	}

	private int convertTimeToInt(String time) {
		String splitted[] = time.split(":");
		return Integer.parseInt(splitted[0]) * 60 * 60
			+ Integer.parseInt(splitted[1]) * 60
			+ Integer.parseInt(splitted[2]);
	}

	private String convertIntToTime(int time) {
		int h = time / 3600;
		int m = time / 60 % 60;
		int s = time % 60;
		return String.format("%02d:%02d:%02d", h, m, s);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String solution1 = solution.solution(
//			"99:59:59"
//			, "25:00:00"
//			, new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}
//		);
		String solution1 = solution.solution(
			"02:03:55"
			, "00:14:15"
			, new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30",
				"01:30:59-01:53:29"}
		);
		System.out.println("solution1 = " + solution1);
	}
}
