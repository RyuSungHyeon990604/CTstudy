package LEETCODE.LongestUnequalAdjacentGroupsSubsequenceII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
		int n = words.length;
		// dp[i] = [0:i] 에서 words[i]를 포함하는 가장 긴 부분수열의 크기
		int[] dp = new int[n];
		int[] prev = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(prev, -1);
		int maxIndex = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if( groups[i] != groups[j]
					&& getHammingDistance(words[i], words[j]) == 1
					&& dp[j] + 1 > dp[i] //위 두 조건을 만족하면서 이전보다 길이가 증가해야함
				){
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
			}
			if(dp[i] > dp[maxIndex]) {
				maxIndex = i;
			}
		}

		List<String> ans = new ArrayList<>();

		for(int i = maxIndex; i >= 0; i = prev[i]) {
			ans.add(words[i]);
		}
		Collections.reverse(ans);
		return ans;
	}

	public int getHammingDistance(String word1, String word2) {
		if(word1.length() != word2.length()) return -1;
		int count = 0;
		for(int i=0; i<word1.length(); i++){
			if(word1.charAt(i)!=word2.charAt(i)){
				count++;
			}
			if(count>1){
				return count;
			}
		}
		return count;
	}
}
