package LEETCODE.TypeofTriangle;

public class Solution {
	public String triangleType(int[] nums) {
		int a = nums[0], b = nums[1], c = nums[2];
		int max = Math.max(Math.max(a, b), c);

		if(a+b+c <= 2 * max)
			return "none";

		if( a == b && b == c )
			return "equilateral";

		if( a == c || b == a || c == b )
			return "isosceles";

		return "scalene";
	}
}
