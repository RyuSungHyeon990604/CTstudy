package LEETCODE.FindthePrefixCommonArrayofTwoArrays;

public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long bit = 0;
        int[] C = new int[A.length];
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if((bit&(1L<<A[i]))>=1) cnt++;
            else bit |= 1L <<A[i];
            if((bit&(1L<<B[i]))>=1) cnt++;
            else bit |= 1L <<B[i];
            C[i] = cnt ;
        }
        return C;
    }
}
