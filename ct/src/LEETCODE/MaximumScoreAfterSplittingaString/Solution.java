package LEETCODE.MaximumScoreAfterSplittingaString;

public class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zero = new int[n+1];
        int[] one = new int[n+1];
        for (int i = 1 ; i <= n ;i++){
            if(s.charAt(i-1) == '1'){
                one[i] = one[i-1]+1;
                zero[i] = zero[i-1];
            }else{
                zero[i] = zero[i-1]+1;
                one[i] = one[i-1];
            }
        }
        int max = -1;
        for(int i = 1; i< n ;i++){
            max = Math.max(max,zero[i] + one[n] - one[i]);
        }

        return max;
    }
}
