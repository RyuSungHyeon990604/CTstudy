package LEETCODE.MaximumNumberofIntegerstoChooseFromaRangeI;

import java.util.Arrays;

public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int answer = 0;
        int m =banned.length;
        int[] range = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            range[i] = i;
        }
        for (int i = m-1; i >= 0; i--) {
            int num = banned[i];
            if(num <= n) {
                range[num] = 0;
            }
        }
        Arrays.sort(range);
        int left = 0,right = n;
        int zeroIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(range[mid] > 0) {
                right = mid - 1;
            }else{
                if(range[mid] == 0)
                    zeroIndex = mid;
                left = mid + 1;
            }
        }
        int sum = 0;
        for (int i = zeroIndex+1; i <= n; i++) {
            sum += range[i];
            answer++;
            if(sum > maxSum){
                answer--;
                break;
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
