import java.util.Objects;

public class Babbling {
    class Root{
        Trie root = new Trie();
        public void insert(String word){
            Trie cur = root;
            for (char c : word.toCharArray()) {
                if(cur.child[c -'a'] == null){
                    cur.child[c -'a'] = new Trie();
                }
                cur =cur.child[c -'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word){
            Trie cur = root;
            String preStr ="";
            StringBuilder curstr = new StringBuilder();
            for (char c : word.toCharArray()) {
                curstr.append(c);
                if(cur.child[c -'a'] == null){
                    return false;
                }
                cur = cur.child[c -'a'];
                if(cur.isWord){
                    if(curstr.toString().equals(preStr) && preStr.isEmpty() == false){
                        return false;
                    }
                    cur = root;
                    preStr = curstr.toString();
                    curstr.setLength(0);
                }
            }
            if(Objects.equals(cur,root)){
                return true;
            }

            return false;
        }
    }
    class Trie{
        Trie[] child = new Trie[26];
        boolean isWord = false;
    }
    public int solution(String[] babbling) {
        int answer = 0;
        Root root = new Root();
        String[] template = new String[]{"aya", "ye", "woo", "ma"};
        for (String s : template){
            root.insert(s);
        }

        for (String s : babbling){
            if(root.search(s)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Babbling b = new Babbling();
        b.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
    }
}
