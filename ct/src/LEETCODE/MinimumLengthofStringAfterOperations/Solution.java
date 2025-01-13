package LEETCODE.MinimumLengthofStringAfterOperations;

public class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur =s.charAt(i) - 'a';
            freq[cur]++;
        }

        for (int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            sum += (freq[i]&1) == 0 ? 2 : 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumLength("abaacbcbb");
    }
}
