package LEETCODE.FruitsIntoBasketsIII;

public class Solution {
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		//과일의 순서 중요, 바구니 순서또한 중요
		//순서가 바뀐다면 결과가 달라질 수 있음 ex) fruits [4,5], baskets [5,4]
		//일때 fruits와 baskets에 대해 정렬작업 수행 후 과일을 바구니에 담을 경우
		//리턴값은 0으로 정답(1) 이 아님.

		//제곱근 분할방식 차용
		int n = baskets.length;
		//sqrt개로 구간 분할 
		int sqrt = (int) Math.sqrt(n);
		int size = (int) Math.ceil((double)n/sqrt);
		int[] sec = new int[size];
		int placed = 0;

		//각 구간의 최댓값
		for (int i = 0; i < baskets.length; i++) {
			sec[i/sqrt] = Math.max(sec[i/sqrt], baskets[i]);
		}

		for (int fruit : fruits) {
			boolean isPlaced = false;
			for (int i = 0; i < size; i++) {
				//각 구간의 최댓값이 과일수보다 적다면 넘긴다
				if(sec[i] < fruit) {
					continue;
				}
				//각 구간을 다시 [0:n] 범위로 치환
				sec[i] = 0;
				for (int j = 0 ;j<sqrt;j++){
					int idx = sqrt*i + j;
					if(idx >= n) break;
					if(!isPlaced && baskets[idx] >= fruit) {
						isPlaced = true;
						baskets[idx] = 0;
						continue;
					}
					sec[i] = Math.max(sec[i], baskets[idx]);
				}
				if(isPlaced) {
					placed++;
					break;
				}
			}
		}
		
		return fruits.length - placed;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int i = s.numOfUnplacedFruits(new int[]{65,51,91,15}, new int[]{94,96,47,72});
		System.out.println("i = " + i);
	}
}
