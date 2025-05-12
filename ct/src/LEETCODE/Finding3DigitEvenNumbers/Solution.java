package LEETCODE.Finding3DigitEvenNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] findEvenNumbers(int[] digits) {
		int[] freq = new int[10];
		for (int digit : digits) {
			freq[digit]++;
		}
		List<Integer> ans = new ArrayList<>();

		for (int f = 1; f < 10; f++) {
			int n = 0;
			if(freq[f] == 0) continue;
			freq[f]--;
			for (int m = 0; m < 10; m++) {
				if(freq[m] == 0) continue;
				freq[m]--;
				for(int l = 0; l < 10; l+=2) {
					if(freq[l] == 0) continue;
					n = f * 100 + m * 10 + l;
				}
				freq[m]++;
			}
			freq[f]++;
			if(n == 0) continue;
			ans.add(n);
		}

		return ans.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.findEvenNumbers(new int[]{2,1,3,0});
	}
}
