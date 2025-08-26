package LEETCODE.MaximumAreaofLongestDiagonalRectangle;

public class Solution {
	public int areaOfMaxDiagonal(int[][] dimensions) {
		int res = 0;
		double diagonal = -1;
		for(int[] dimension : dimensions) {
			int t = dimension[0]*dimension[0] + dimension[1]*dimension[1];
			int area = dimension[0] * dimension[1];

			if(diagonal == t && area > res) {
				res = area;
				continue;
			}

			if(t > diagonal) {
				diagonal = t;
				res = area;
			}
		}
		return res;
	}
}
