package 프로그래머스.야근지수;
import java.util.TreeMap;

public class Solution {
	//야근 피로도 += 야근을 시작한 시점에서 남은 일의 작업량 ^ 2
	public long solution(int n, int[] works) {
		long answer = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int work : works) {
			map.put(work, map.getOrDefault(work, 0) + 1);
		}

		while(n > 0) {
			int v = map.lastKey();
			if(v == 0) return 0;

			int count = map.get(v);
			if(n >= count) {
				map.put(v-1, map.getOrDefault(v-1, 0) + count);
				map.remove(v);
				n -= count;
			} else {
				map.put(v, count - n);
				map.put(v-1, map.getOrDefault(v-1, 0) + n);
				n=0;
			}
		}

		for (Integer i : map.keySet()) {
			answer += ((long) i * i) * map.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		long solution1 = solution.solution(3, new int[]{1, 1});
		System.out.println("solution1 = " + solution1);
	}
}
