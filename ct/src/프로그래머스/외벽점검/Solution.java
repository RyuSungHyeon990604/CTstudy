package 프로그래머스.외벽점검;

import java.util.Arrays;

public class Solution {
	int answer = -1;

	public int solution(int n, int[] weak, int[] dist) {
		int[] arr = new int[weak.length * 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i / weak.length * n) + weak[i % weak.length];
		}
		Arrays.sort(dist);
		for (int friends = 1; friends <= dist.length; friends++) {
			for (int start = 0; start < weak.length; start++) {

				back(arr, start, dist, new int[friends], new boolean[dist.length], 0);
				if(answer > 0) return answer;
			}
		}

		return -1;
	}

	public void back(int[] arr, int start, int[] dist, int[] combPermutation, boolean[] vis, int depth) {
		if(depth == combPermutation.length) {
			if(chk(arr, start, combPermutation)) {
				answer = combPermutation.length;
			}
			return;
		}

		if(answer > 0 ) return;

		for (int i = 0; i < dist.length; i++) {
			if(!vis[i]) {
				vis[i] = true;
				combPermutation[depth] = dist[i];
				back(arr, start, dist, combPermutation, vis, depth + 1);
				vis[i] = false;
			}
		}
	}


	public boolean chk(int[] arr, int start, int[] dist) {
		int end = start + (arr.length / 2);
		for (int i = 0; i < dist.length; i++) {
			int distance = arr[start] + dist[i];
			while (start <  end  && arr[start] <= distance) {
				start++;
			}
			if(start >= end) {
				return true;
			}
		}
		return false;
	}



	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(16, new int[]{1,2,3,4,5,7,8,10,11,12,14,15}, new int[]{4,2,1,1});
		System.out.println("solution1 = " + solution1);
	}
}
