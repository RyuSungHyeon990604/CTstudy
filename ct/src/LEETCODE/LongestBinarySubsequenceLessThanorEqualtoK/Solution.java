package LEETCODE.LongestBinarySubsequenceLessThanorEqualtoK;

public class Solution {
	public int longestSubsequence(String s, int k) {
		long v = 0;
		int bit = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				bit++;
			} else {
				if( (v + (1L<<bit)) <= k && bit < 32) {
					v+=(1L<<bit);
					bit++;
				}
			}
		}
		return bit;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.longestSubsequence("1001010", 5);
	}
}
