package LEETCODE.WordSubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        int[][] freq1 = new int[words2.length][26];
        int[][] freq2 = new int[words1.length][26];
        int[] count = new int[26];
        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < words2[i].length(); j++) {
                freq1[i][words2[i].charAt(j)-'a']++;
            }
        }
        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < 26; j++) {
                count[j] = Math.max(count[j], freq1[i][j]);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words1[i].length(); j++) {
                freq2[i][words1[i].charAt(j)-'a']++;
            }
        }
        for (int i = 0; i < words1.length; i++) {
            boolean isContain = true;
            for (int j = 0; j < 26; j++) {
                if(freq2[i][j] < count[j]){
                    isContain = false;
                    break;
                }
            }
            if(isContain){
                res.add(words1[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"lo","eo"});
    }
}
