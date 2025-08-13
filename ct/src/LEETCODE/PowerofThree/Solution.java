package LEETCODE.PowerofThree;

public class Solution {
	public boolean isPowerOfThree(int n) {
		if(n <= 0) return false;
		while(n % 3 == 0) {
			n = n / 3;
		}
		return n==1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		boolean powerOfThree = s.isPowerOfThree(3);
		System.out.println(powerOfThree);
	}
}
