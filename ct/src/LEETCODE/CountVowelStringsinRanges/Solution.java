package LEETCODE.CountVowelStringsinRanges;

public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length+1];
        int[] answer = new int[queries.length];
        for (int i = 1; i < words.length + 1; i++) {
            char start = words[i-1].charAt(0);
            char end = words[i-1].charAt(words[i-1].length()-1);
            if(isValid(start) && isValid(end)){
                prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = prefix[queries[i][1]+1] - prefix[queries[i][0]];
        }
        return answer;
    }
    private boolean isValid(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u';
    }
}
