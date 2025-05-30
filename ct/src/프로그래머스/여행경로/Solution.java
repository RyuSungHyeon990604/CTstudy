package 프로그래머스.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	private final String FIRST_AIRPORT = "ICN";
	public String[] solution(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			map.computeIfAbsent(ticket[0], key->new PriorityQueue<>()).add(ticket[1]);
		}
		List<String> list = new ArrayList<>();

		dfs(map, list, FIRST_AIRPORT);
		Collections.reverse(list);
		return list.toArray(new String[0]);
	}

	//List<String> list => Dequeue 로도 개선 가능할듯
	//후위순회 이유 기억하기
	public void dfs(Map<String, PriorityQueue<String>> map, List<String> list, String cur) {
		while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
			dfs(map, list, map.get(cur).poll());
		}
		list.add(cur);
	}



	public static void main(String[] args) {
		Solution solution = new Solution();
		//String[] solution1 = solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
		String[] solution1 = solution.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "BBB"}, {"ICN", "CCC"}, {"CCC", "ICN"}, {"BBB", "ICN"}});
		for (String s : solution1) {
			System.out.println("s = " + s);
		}
	}
}
