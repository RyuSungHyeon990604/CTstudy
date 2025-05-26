package 프로그래머스.선입선출스케줄링;

public class Solution {
	public int solution(int n, int[] cores) {
		//제한사항에 의해 최대 시간은 250000000
		int left = 0, right = 250000000;
		int minTime = 250000000;
		while (left < right) {
			int mid = (left + right) / 2;
			if(countProceedJob(cores, mid) >= n) {
				right = mid-1;
				minTime = mid;
			} else {
				left = mid + 1;
			}
		}
		long preJob = countProceedJob(cores, minTime-1);

		for (int i = 0; i < cores.length; i++) {
			if(minTime % cores[i] == 0) {
				preJob += 1;
				if(preJob == n) return i+1;
			}
		}

		return -1;
	}

	private long countProceedJob(int[] cores, int time) {
		long sum = 0;
		for (int i = 0; i < cores.length; i++) {
			sum += time / cores[i] + 1;
		}
		return sum;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(6, new int[]{1, 2, 3});
		System.out.println("solution1 = " + solution1);
	}
}
