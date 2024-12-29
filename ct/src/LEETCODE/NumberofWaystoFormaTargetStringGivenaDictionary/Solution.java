package LEETCODE.NumberofWaystoFormaTargetStringGivenaDictionary;

import java.util.Arrays;

public class Solution {
    private long res = 0;
    private int MOD = 1000000007;
    private long[][] dp;
    public int numWays(String[] words, String target) {
        int maxLen = words[0].length();
        for(int i = 0 ;i < words.length;i++){
            maxLen = Math.max(maxLen, words[i].length());
        }
        int[][] freq = new int[maxLen][26];
        for(int i = 0 ;i < words.length;i++){
            for(int j = 0; j < words[i].length();j++){
                freq[j][(int) (words[i].charAt(j)-'a')]++;
            }
        }
        //dp[i][j] 의 뜻 : freq[i]에서 target.chartAt(j) 문자를 선탣했을때의 완성할수있는 경우의 수
        dp = new long[maxLen+1][target.length()+1];
        for(int i = 0 ;i <= maxLen;i++){
            Arrays.fill(dp[i], -1);
        }

        res = dfs(freq,target,0,0,maxLen);
        return (int) res;
    }
    public long dfs(int[][] freq,String target,int level,int targetIndex,int limit){
        //문자를 완성했다면 +1
        if(targetIndex == target.length()){
            return 1;
        }
        //완성하지 못했다면 0
        if(level == limit){
            return 0;
        }
        if(dp[level][targetIndex] != -1){
            return dp[level][targetIndex];
        }
        //다음 레벨에서 현재의 문자를 찾는다
        long skip = dfs(freq, target, level+1, targetIndex, limit);

        //다음 레벨에서 다음 문자를 찾는다
        long next = 0;
        //현재 레벨에서 문자를 완성할수있는 경우 = 다음레벨에서 문자를 완성할수있는 경우 * 현재 문자의 갯수
        if(freq[level][target.charAt(targetIndex) - 'a'] > 0)
            next = (freq[level][target.charAt(targetIndex) - 'a'] * dfs(freq, target, level+1, targetIndex+1, limit) % MOD);


        dp[level][targetIndex] = (next+skip)%MOD;

        return dp[level][targetIndex];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numWays(new String[]{"cabbaacaaaccaabbbbaccacbabbbcb","bbcabcbcccbcacbbbaacacaaabbbac","cbabcaacbcaaabbcbaabaababbacbc","aacabbbcaaccaabbaccacabccaacca","bbabbaabcaabccbbabccaaccbabcab","bcaccbbaaccaabcbabbacaccbbcbbb","cbbcbcaaaacacabbbabacbaabbabaa","cbbbbbbcccbabbacacacacccbbccca","bcbccbccacccacaababcbcbbacbbbc","ccacaabaaabbbacacbacbaaacbcaca","bacaaaabaabccbcbbaacacccabbbcb","bcbcbcabbccabacbcbcaccacbcaaab","babbbcccbbbbbaabbbacbbaabaabcc","baaaacaaacbbaacccababbaacccbcb","babbaaabaaccaabacbbbacbcbababa","cbacacbacaaacbaaaabacbbccccaca","bcbcaccaabacaacaaaccaabbcacaaa","cccbabccaabbcbccbbabaaacbacaaa","bbbcabacbbcabcbcaaccbcacacccca","ccccbbaababacbabcaacabaccbabaa","caaabccbcaaccabbcbcaacccbcacba","cccbcaacbabaacbaaabbbbcbbbbcbb","cababbcacbabcbaababcbcabbaabba","aaaacacaaccbacacbbbbccaabcccca","cbcaaaaabacbacaccbcbcbccaabaac","bcbbccbabaccabcccacbbaacbbcbba","cccbabbbcbbabccbbabbbbcaaccaab","acccacccaabbcaccbcaaccbababacc","bcacabaacccbbcbbacabbbbbcaaaab","cacccaacbcbccbabccabbcbabbcacc","aacabbabcaacbaaacaabcabcaccaab","cccacabacbabccbccaaaaabbcacbcc","cabaacacacaaabaacaabababccbaaa","caabaccaacccbaabcacbcbbabccabc","bcbbccbbaaacbaacbccbcbababcacb","bbabbcabcbbcababbbbccabaaccbca","cacbbbccabaaaaccacbcbabaabbcba","ccbcacbabababbbcbcabbcccaccbca","acccabcacbcbbcbccaccaacbabcaab","ccacaabcbbaabaaccbabcbacaaabaa","cbabbbbcabbbbcbccabaabccaccaca","acbbbbbccabacabcbbabcaacbbaacc","baaababbcabcacbbcbabacbcbaaabc","cabbcabcbbacaaaaacbcbbcacaccac"},"acbaccacbbaaabbbabac");
    }
}
