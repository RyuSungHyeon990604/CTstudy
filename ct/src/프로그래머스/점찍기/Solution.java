package 프로그래머스.점찍기;

public class Solution {
	public long solution(int k, int d) {
		//모든 점의 x, y 좌표는 k배수 ==> (k*n1, k*n2) ,  0 <= n1, n2 는 정수
		//원점과 점 사이의 거리는 d를 넘지 않음
		long dist = d;
		long answer = 0;
		for (long i = 0; i < d+1; i+=k) {
			answer += (long) (Math.sqrt(dist*dist - i*i) / k + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(1, 1000000);
	}
}
