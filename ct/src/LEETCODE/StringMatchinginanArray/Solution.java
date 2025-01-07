package LEETCODE.StringMatchinginanArray;

import java.util.*;

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words,(a,b)->b.length()-a.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            if(sb.toString().contains(words[i])){
                res.add(words[i]);
            }
            sb.append(words[i]);
        }

        return res;
    }
}
