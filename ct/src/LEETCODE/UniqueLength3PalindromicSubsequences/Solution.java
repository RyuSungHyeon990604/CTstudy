package LEETCODE.UniqueLength3PalindromicSubsequences;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countPalindromicSubsequence1(String s) {
        int n = s.length();
        if(n < 3) return 0;
        int[] bitMap = new int[26];
        int[] right = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0;i<n;i++){
            right[chars[i] - 'a']++;
        }
        int res=0;
        int[] left = new int[26];
        for (int i = 0;i<n;i++){
            int c = chars[i] - 'a';
            right[c]--;
            for(int j =0; j < 26 ;j++){
                if(right[j]>0 && left[j] > 0){
                    if((bitMap[c] & (1<<j)) == 0){
                        res++;
                        bitMap[c]  |=  1<<j;
                    }
                }
            }
            left[c]++;
        }
        return res;
    }
    public int countPalindromicSubsequence2(String s) {
        int n = s.length();
        if(n < 3) return 0;
        Set<Integer> set = new HashSet<>();
        int[] right = new int[26];
        for (int i = 0;i<n;i++){
            right[s.charAt(i) - 'a']++;
        }
        int[] left = new int[26];
        for (int i = 0;i<n;i++){
            int c = s.charAt(i) - 'a';
            right[c]--;
            if(i == 0 || i == n-1) {
                left[c]++;
                continue;
            }
            for(int j =0; j < 26 ;j++){
                if(right[j]>0 && left[j] > 0){
                    int bit = (j << 10) | (c << 5) | j;
                    set.add(bit);
                }
            }
            left[c]++;
        }
        return set.size();
    }
}
