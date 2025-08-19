package LEETCODE.NumberofZeroFilledSubarrays;

public class Solution {
	public long zeroFilledSubarray(int[] nums) {
		long res = 0;
		int c = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				c++;
				res += c;
			} else {
				c = 0;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {0,0,0,2,0,0};
		System.out.println(s.zeroFilledSubarray(nums));
	}
}
