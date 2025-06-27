package LEETCODE.LongestSubsequenceRepeatedkTimes;

public class Solution {

	private String res = "";

	public String longestSubsequenceRepeatedK(String s, int k) {

		int[] freq = new int[26];
		int[] possibleChars = new int[26];
		int maxSubLen = 0;
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			possibleChars[i] = freq[i] / k;
			maxSubLen += possibleChars[i];
		}

		maxSubLen = Math.min(maxSubLen, s.length() / k);
		for (int len = maxSubLen; len > 0; len--) {
			subsequence(s, k, possibleChars, new char[len], 0);
		}

		return res;
	}

	public void subsequence(String s, int k, int[] possibleChars, char[] chars, int idx) {
		if (chars.length == idx) {
			int cnt = 0;
			int charIdx = 0;
			for (int i = 0; i < s.length(); i++) {
				charIdx = charIdx + (s.charAt(i) == chars[charIdx] ? 1 : 0);
				if (charIdx == chars.length) {
					cnt++;
					charIdx = 0;
				}
				if (cnt >= k) {
					res = new String(chars);
					return;
				}
			}
			return;
		}

		for (int i = 25; i >= 0; i--) {
			if (!res.isBlank()) {
				break;
			}
			if (possibleChars[i] > 0) {
				possibleChars[i]--;
				chars[idx] = (char) (i + 'a');
				subsequence(s, k, possibleChars, chars, idx + 1);
				possibleChars[i]++;
			}
		}
	}


	public static void main(String[] args) {
		Solution s = new Solution();
		String s1 = s.longestSubsequenceRepeatedK("letsleetcode", 2);
		System.out.println(s1);
	}
}
