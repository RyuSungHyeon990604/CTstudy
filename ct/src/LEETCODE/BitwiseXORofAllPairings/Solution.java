package LEETCODE.BitwiseXORofAllPairings;

public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int num1 = nums1[0];
        for (int i = 1; i < nums1.length; i++) {
            num1 = num1 ^ nums1[i];
        }
        int num2 = nums2[0];
        for (int i = 1; i < nums2.length; i++) {
            num2 = num2 ^ nums2[i];
        }
        if((nums1.length&1)==0 ){
            num2 = 0;
        }
        if((nums2.length&1)==0){
            num1 = 0;
        }
        return num1^num2;
    }
}
