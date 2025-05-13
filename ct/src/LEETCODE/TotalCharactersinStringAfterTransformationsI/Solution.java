package LEETCODE.TotalCharactersinStringAfterTransformationsI;

public class Solution {
	private static final int MOD = 1000000007;
	public int lengthAfterTransformations(String s, int t) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		int n = t % 26;
		for (int i = 0; i < n; i++) {
			int[] newFreq = new int[26];
			for (int j = 0; j < 26; j++) {
				if(freq[j] > 0) {
					if(j == 25) {
						newFreq[0] = (newFreq[0] + freq[j]) % MOD;
						newFreq[1] = (newFreq[1] + freq[j]) % MOD;
					} else {
						newFreq[j+1] = (newFreq[j+1] + freq[j]) % MOD;
					}
				}
			}
			freq = newFreq;
		}


		n = t / 26;
		for (int i = 0; i < n; i++) {
			int[] newFreq = new int[26];
			for (int j = 0; j < 26; j++) {
				if(freq[j] > 0) {
					if(j == 25) {
						newFreq[j] = (newFreq[j] + freq[j]) % MOD;
						newFreq[0] = (newFreq[0] + freq[j]) % MOD;
						newFreq[1] = (newFreq[1] + freq[j]) % MOD;
					} else {
						newFreq[j] = (newFreq[j] + freq[j]) % MOD;
						newFreq[j+1] = (newFreq[j+1] + freq[j]) % MOD;
					}
				}
			}
			freq = newFreq;
		}


		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum = (sum + freq[i]) % MOD;
		}

		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.lengthAfterTransformations("abcyy", 2);
	}
}
