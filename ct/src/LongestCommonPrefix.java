import java.util.Arrays;

public class LongestCommonPrefix {
    class Root{
        Trie top;
        Root(){
            this.top = new Trie();
        }
        public void insert(String word){
            Trie cur = this.top;
            for(char c : word.toCharArray()){
                if(cur.child[c - '0'] == null){
                    Trie trie = new Trie();
                    cur.child[c - '0'] = trie;
                }
                cur = cur.child[c - '0'];
            }
        }
        public int getLongestCommonPrefixLength(String word){
            int max = 0;
            Trie cur = this.top;
            for(char c : word.toCharArray()){
                if(cur.child[c - '0'] == null)
                    break;
                cur = cur.child[c - '0'];
                max +=1;
            }
            return max;
        }
    }
    class Trie{
        Trie[] child;
        public Trie(){
            this.child = new Trie[10];
        }

    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLen = 0;
        int[] trie = arr1.length >= arr2.length ? arr1 : arr2;
        int[] search = arr1.length >= arr2.length ? arr2 : arr1;
        Root root1 = new Root();
        for(int i=0; i<trie.length; i++){
            root1.insert(String.valueOf(trie[i]));
        }
        for (int i=0; i<search.length; i++){
            maxLen = Math.max(maxLen,root1.getLongestCommonPrefixLength(String.valueOf(search[i])));
        }


        return maxLen;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        int i = longestCommonPrefix.longestCommonPrefix(new int[]{1, 10,12, 100}, new int[]{100});
        System.out.println("longestCommonPrefix = " + i);
    }
}
