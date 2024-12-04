package LEETCODE.MakeStringaSubsequenceUsingCyclicIncrements;

public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()) return false;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int cnt = 0;
        int left = 0;
        for(int i = 0 ; i < s2.length; i++){
            int target = s2[i]-'a';
            while(left < str1.length()){
                int cur = s1[left++] - 'a';
                if(cur == target || (cur+1)%26 == target){
                    cnt++;
                    break;
                }
            }
        }
        return cnt == s2.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.canMakeSubsequence("om", "nm");
        System.out.println("b = " + b);
    }
}
