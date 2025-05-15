package LEETCODE.LongestＵnequalAdjacentGroupsSubsequenceI;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> getLongestSubsequence(String[] words, int[] groups) {
		List<String> result = new ArrayList<>();
		result.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if(groups[i] != groups[i-1]){
				result.add(words[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.getLongestSubsequence(new String[]{"c","w","h","s"},new int[]{0,0,0,1});
	}
}
