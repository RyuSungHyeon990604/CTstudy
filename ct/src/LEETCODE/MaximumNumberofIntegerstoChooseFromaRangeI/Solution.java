package LEETCODE.MaximumNumberofIntegerstoChooseFromaRangeI;

import java.util.Arrays;

public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int answer = 0;
        int[] range = new int[10001];
        for (int num : banned) {
            range[num] = 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(range[i] == 0){
                sum += i;
                answer++;
                if(sum > maxSum){
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int i = s.maxCount(new int[]{11}, 7, 50);
        System.out.println("i = " + i);
    }
}
