package LEETCODE.CheckIfaWordOccursAsaPrefixofAnyWordinaSentence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Root{
        Trie root;
        Root(){
            root = new Trie();
        }
        public void insert(String word,int i){
            Trie cur = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(cur.child[index] == null){
                    cur.child[index] = new Trie();
                }
                cur = cur.child[index];
                if(cur.firstIndex == -1) cur.firstIndex = i;
            }
        }
        public int getIndexOfFirstWord(String searchWord){
            Trie cur = root;
            for(char c : searchWord.toCharArray()){
                int index = c - 'a';
                if(cur.child[index] == null){
                    return -1;
                }
                cur = cur.child[index];
            }
            return cur.firstIndex;
        }
    }
    class Trie{
        Trie[] child = new Trie[26];
        int firstIndex = -1;
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        Root root = new Root();
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            root.insert(words[i], i+1);
        }
        return root.getIndexOfFirstWord(searchWord);
    }
    public int isPrefixOfWord2(String sentence, String searchWord) {
        String arr[]=sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].startsWith(searchWord))
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int prefixOfWord = solution.isPrefixOfWord("this problem is an easy problem", "pro");
        System.out.println("prefixOfWord = " + prefixOfWord);
    }
}
