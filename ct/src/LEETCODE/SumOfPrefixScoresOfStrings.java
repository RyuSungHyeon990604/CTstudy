public class SumOfPrefixScoresOfStrings {
    class Root{
        Trie top;
        Root(){
            this.top = new Trie();
        }
        public void insert(String word){
            Trie cur = top;
            for (char c : word.toCharArray()) {
                if(cur.child[c - 'a'] == null){
                    Trie trie = new Trie();
                    trie.count = 1;
                    cur.child[c - 'a'] = trie;
                }else{
                    cur.child[c - 'a'].count = cur.child[c - 'a'].count+1;
                }
                cur = cur.child[c - 'a'];
            }
        }
        public int getCount(String word){
            int sum = 0;
            Trie cur = top;
            for (char c : word.toCharArray()) {
                if(cur.child[c - 'a'] == null){
                    break;
                }
                cur = cur.child[c - 'a'];
                sum += cur.count;
            }
            return sum;
        }

    }
    class Trie{
        Trie[] child;
        int count;
        Trie(){
            child = new Trie[26];
            count = 0;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        Root root = new Root();
        if(words.length == 1) {
            return new int[]{words[0].length()};
        }

        for (String word : words) {
            root.insert(word);
        }

        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            res[i] = root.getCount(word);
        }



        
        return res;
    }

    public static void main(String[] args) {
        SumOfPrefixScoresOfStrings s = new SumOfPrefixScoresOfStrings();
        int[] ints = s.sumPrefixScores(new String[]{"abc","ab","bc","b"});
        
        for (int i : ints){
            System.out.println("i = " + i);
        }
    }
}
