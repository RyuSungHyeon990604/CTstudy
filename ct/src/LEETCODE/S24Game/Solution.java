package LEETCODE.S24Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	private final double EPS = 1e-6;
	public boolean judgePoint24(int[] cards) {
		List<Double> list = new ArrayList<Double>();
		for(int i = 0; i < cards.length; i++){
			list.add((double) cards[i]);
		}
		return dfs(list);
	}

	//2개의 인덱스를 추출
	public boolean dfs(List<Double> list) {
		if(list.size() == 1) {
			return Math.abs(list.get(0) - 24) <= EPS;
		}
		for(int i = 0; i < list.size(); i++){
			for(int j = i + 1; j < list.size(); j++){
				Double v1 = list.get(i);
				Double v2 = list.get(j);

				Set<Double> calced = new HashSet<>();
				if(Math.abs(v2) > EPS) {
					calced.add(v1/v2);
				}
				if(Math.abs(v1) > EPS) {
					calced.add(v2/v1);
				}
				calced.add(v1+v2);
				calced.add(v1*v2);
				calced.add(v1-v2);
				calced.add(v2-v1);
				for (Double v : calced) {
					List<Double> temp = new ArrayList<>(list);
					temp.remove(i);
					temp.remove(j-1);
					temp.add(v);
					if(dfs(temp)) return true;
				}

			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		boolean b = s.judgePoint24(new int[]{4,1,8,7});
		System.out.println("b = " + b);
	}
	
}
