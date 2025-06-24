package LEETCODE.FindAllKDistantIndicesinanArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		int left = 0, right = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == key){
				left =Math.max(right, i-k);
				right = Math.min(i+k, nums.length)+1;
				for (int j = left; j < right; j++) {
					result.add(j);
				}
			}
		}
		return result;
	}
}
