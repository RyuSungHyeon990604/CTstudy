package LEETCODE.FruitsIntoBasketsII;

public class Solution {
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int res = fruits.length;
		for (int i = 0; i < fruits.length; i++) {
			int f = fruits[i];
			for (int j = 0; j < baskets.length; j++) {
				if (f <= baskets[j]) {
					baskets[j] = -1;
					res--;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int i = s.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4});
		System.out.println("i = " + i);
	}

}
