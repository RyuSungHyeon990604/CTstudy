package LEETCODE.PowerofFour;

public class Solution {
	public boolean isPowerOfFour(int n) {
		if(n <= 0) return false;
		return (n & (n-1)) == 0 && (Integer.bitCount(n-1) & 1) == 0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.isPowerOfFour(4);
	}
}
