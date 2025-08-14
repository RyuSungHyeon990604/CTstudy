package LEETCODE.Largest3SameDigitNumberinString;

public class Solution {
	public String largestGoodInteger(String num) {
		int[] c = new int[num.length()];
		c[0] = 1;
		boolean flag = false;
		char pre = '0';
		for (int i = 1; i < num.length() ; i++) {
			c[i] = num.charAt(i) == num.charAt(i-1) ? c[i-1]+1 : 1;
			if(c[i] >= 3) {
				if(num.charAt(i) >= pre) {
					pre = num.charAt(i);
				}
				flag = true;
			}
		}

		return flag ? new String(new char[]{pre, pre, pre}) : "";
	}

	public String largestGoodInteger3(String num) {
		int[] c = new int[num.length()];
		c[0] = 1;
		int pre = -1;
		for (int i = 1; i < num.length() ; i++) {
			c[i] = num.charAt(i) == num.charAt(i-1) ? c[i-1]+1 : 1;
			if(c[i] >= 3) {
				if(num.charAt(i) - '0' >= pre) {
					pre = num.charAt(i) - '0';
				}
			}
		}
		if(pre == -1) return "";
		if(pre == 0) return "000";
		return String.valueOf(100*pre + 10*pre + pre);
	}

	public String largestGoodInteger2(String num) {
		String[] template = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
		for (String s : template) {
			if(num.contains(s)) {
				return s;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String s1 = s.largestGoodInteger("111");
		System.out.println("s1 = " + s1);
	}
}
