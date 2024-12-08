package LEETCODE.MaximumPopulationYear;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] p = new int[101];
        for (int i = 0; i < logs.length; i++) {
            int b = logs[i][0]-1950;
            int d = logs[i][1]-1950;
            p[b] += 1;
            p[d] -= 1;
        }
        int prefixSum = 0;
        int max = Integer.MIN_VALUE;
        int earliestYear = 1950;
        for (int i = 0; i < p.length; i++) {
            prefixSum += p[i];
            if (prefixSum > max){
                max = prefixSum;
                earliestYear = i+1950;
            }
        }

        return earliestYear;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumPopulation(new int[][]{{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}});
    }
}
