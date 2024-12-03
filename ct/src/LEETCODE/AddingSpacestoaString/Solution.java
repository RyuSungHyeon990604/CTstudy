package LEETCODE.AddingSpacestoaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = spaces.length;
        char[] arr= new char[s.length()+n];
        char[] c = s.toCharArray();
        int start = 0;
        for(int i=0;i<n;i++){
            int end = spaces[i];
            for (; start < end; start++) {
                arr[start+i] = c[start];
            }
            arr[end+i] = ' ';
        }
        if(start <= c.length-1){
            for (; start < s.length(); start++) {
                arr[start+n] = c[start];
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addSpaces("spacing",new int[]{0,1,2,3,4,5,6});
    }
}
