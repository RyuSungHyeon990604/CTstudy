package LEETCODE.FindLongestSpecialSubstringThatOccursThriceI;

public class Solution {
    class Root{
        Trie root;
        public Root(){
            root = new Trie();
        }
        public void insert(String word,int startIndex){
            Trie cur = root;

            for(int i = startIndex; i < word.length(); i++){
                char curChar = word.charAt(i);
                if(i > startIndex && curChar != word.charAt(i-1)){
                    return;
                }
                int index = curChar - 'a';
                if(cur.child[index] == null){
                    cur.child[index] = new Trie();
                }
                cur = cur.child[index];
                cur.freq++;
            }
        }
        public int maximumLength(int least){
            int max = -1;
            for(int i = 0; i < 26; i++){
                Trie cur = root;
                if(cur.child[i] != null){
                    int len = 0;

                    while(cur.child[i] != null && cur.child[i].freq >= least){
                        len++;
                        cur = cur.child[i];
                    }
                    if(len != 0){
                        max = Math.max(max, len);
                    }
                }
            }
            return max;
        }
    }
    class Trie{
        Trie[] child = new Trie[26];
        int freq = 0;
    }
    public int maximumLength(String s) {
        int answer = Integer.MIN_VALUE;
        Root root = new Root();
        for(int i = 0; i < s.length(); i++){
            root.insert(s,i);
        }
        return root.maximumLength(3);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.maximumLength("");
        System.out.println("i = " + i);
    }
}
