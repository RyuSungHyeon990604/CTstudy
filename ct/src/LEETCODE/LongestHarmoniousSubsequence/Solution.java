package LEETCODE.LongestHarmoniousSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int findLHS(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			int j = i;
			while(j < nums.length && nums[j] == cur) {
				j++;
			}
			if(j < nums.length && nums[j] == cur+1) {
				int k = j;
				while(k < nums.length && nums[k] == nums[j]) {
					k++;
				}
				res = Math.max(res, k - i);
			}
			i=j-1;
		}
		return res;
	}

	public int findLHS2(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for(int key : map.keySet()) {
			if(map.containsKey(key + 1)) {
				res = Math.max(res, map.get(key + 1) + map.get(key));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.findLHS(new int[]{1,3,2,2,5,2,3,7});
	}
}
