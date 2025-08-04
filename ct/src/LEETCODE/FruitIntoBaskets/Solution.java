package LEETCODE.FruitIntoBaskets;

public class Solution {
	public int totalFruit(int[] fruits) {
		int res = 0;
		int len = 0;
		int[] t = new  int[fruits.length+1];
		int l = 0, r = 0;
		while(r < fruits.length) {
			//더해서 1이되면 길이를 추가해주어야함
			if(++t[fruits[r]] == 1) {
				len++;
			}

			if(len > 2) {
				//1. fruits[l]의 갯수를 감소 및 l = l + 1
				//2. 0으로 갑소됐을경우 길이또한 감소
				if(--t[fruits[l++]] == 0) {
					len--;
				}
			}
			if(len <= 2) {
				res =  Math.max(res, r - l + 1);
			}
			r++;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.totalFruit(new int[]{0,1,2,2}));
	}
}
