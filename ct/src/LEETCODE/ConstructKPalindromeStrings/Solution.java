package LEETCODE.ConstructKPalindromeStrings;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() == k) return true;
        if(s.length() < k) return false;

        int[] freq = new int[26];
        for (int i = 0 ; i < s.length() ;i++){
            freq[s.charAt(i)-'a']++;
        }
        int cnt =0;
        for(int i = 0; i< 26 ;i++){
            if((freq[i]&1) == 1){
                cnt++;
            }
        }
        return cnt <= k ;
    }
}
