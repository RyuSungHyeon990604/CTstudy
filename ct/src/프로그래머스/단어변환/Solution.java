package 프로그래머스.단어변환;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n  = words.length;
        boolean[] vis = new boolean[n];
        Queue<String> queue = new LinkedList<String>();

        queue.add(begin);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String word = queue.poll();
                if(word.equals(target)) {
                    return answer;
                }
                for(int i = 0; i < n; i++) {
                    if(!vis[i] && canChange(word,words[i])) {
                        vis[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    private boolean canChange(String s1,String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if(diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log"});
    }
}
