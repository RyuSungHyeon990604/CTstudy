package 프로그래머스.택배배달과수거하기;

public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for(int i = n-1; i >=0;i--){
            if(i < n-1){
                deliveries[i] += deliveries[i+1];
                pickups[i] += pickups[i+1];
            }
            while(deliveries[i] > 0 || pickups[i] > 0){
                deliveries[i] -= cap;
                pickups[i] -= cap;
                answer += (i+1)*2;
            }
        }
        return answer;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2,7,new int[]{1, 0, 2, 0, 1, 0, 2},new int[]{0, 2, 0, 1, 0, 2, 0});
    }
}
