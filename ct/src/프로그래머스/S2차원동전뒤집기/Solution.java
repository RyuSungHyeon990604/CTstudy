package 프로그래머스.S2차원동전뒤집기;

public class Solution {
	private int answer = Integer.MAX_VALUE;
	public int solution(int[][] beginning, int[][] target) {
		int n = beginning.length;
		int m = beginning[0].length;
		//각 요소의 차이를 행으로 묶어 비트 연산
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			int num = 0;
			for(int j = 0; j < m; j++){
				if(beginning[i][j] != target[i][j]){
					num = num | (1<<j);
				}
			}
			arr[i] = num;
		}
		if(!chk(arr, m)) return -1;
		
		//xor연산 했을때 모든 비트를 반전시켜주는 숫자
		int reverseNumber = (1<<m) - 1;
		reverseBit(arr, reverseNumber, 0, 0);
		
		//최소 횟수 구하기

		return answer;
	}

	//arr에서 2개를 뽑아 xor연산 시 0 또는 2^m - 1 이 여야 함
	public boolean chk(int[] arr, int m) {
		
		for(int i = 0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				int a = arr[i];
				int b = arr[j];
				if((a^b) != 0 && (a^b) != (1<<m)-1) return false;
			}
		}
		return true;
	}
	
	public void reverseBit(int[] arr, int reversNum, int start, int count) {
		if(count > answer) return;
		if(allRowsEqual(arr)) {
			answer = Math.min(answer, count + Integer.bitCount(arr[0]));
		}
		for (int i = start; i < arr.length; i++) {
			int t = arr[i];
			arr[i] = arr[i] ^ reversNum;
			reverseBit(arr, reversNum, i+1, count+1);
			arr[i] = t;
		}
	}
	
	public boolean allRowsEqual(int[] arr) {
		int n = arr[0];
		for (int i : arr) {
			if(i != n) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr1 = new int[][]{
			{0, 1, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{0, 1, 1, 1, 0},
			{1, 0, 1, 1, 0},
			{0, 1, 0, 1, 0}};
		int[][] arr2 = new int[][]{
			{0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1},
			{0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0},
			{0, 0, 0, 0, 1}
		};
		int solution = s.solution(arr1, arr2);
		System.out.println("solution = " + solution);
	}
}
