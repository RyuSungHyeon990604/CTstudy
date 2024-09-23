import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersInAString {
    class Root{
        Trie top;
        Root(Trie nodes){
            this.top = nodes;
        }

        public int getExtraCharactersCount(String str){
            int count = 0;
            //metzeaencgpgvsckjrqafkxgyzbe
            char[] charArray = str.toCharArray();
            for(int i = 0; i<charArray.length; i++){
                int j = i;
                Trie cur = top;
                int strLen = 0;
                while(j<charArray.length){
                    char c = charArray[j];
                    boolean isContains = cur.children.containsKey(c);
                    if(isContains){
                        cur = cur.children.get(c);
                        if(cur.isEnd){
                            strLen = j - i + 1;
                        }
                    }else{
                        break;
                    }
                    j++;
                }
                if(strLen > 0){
                    i += strLen - 1;
                }else{
                    count++;
                }

            }



            return count;
        }
    }
    class Trie{
        boolean isEnd;
        Map<Character, Trie> children;

        Trie(){
            children = new HashMap<Character, Trie>();
            isEnd = false;
        }

        public void insert(String word){
            Trie cur = this;
            char[] charArray = word.toCharArray();
            for(int i = 0; i < charArray.length ;i++ ){
                cur.children.putIfAbsent(charArray[i], new Trie());
                cur= cur.children.get(charArray[i]);
            }
            cur.isEnd = true;

        }

    }

    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        Root root = new Root(trie);
        for (String str : dictionary) {
            root.top.insert(str);
        }
        return root.getExtraCharactersCount(s);

    }

    public static void main(String[] args) {
        ExtraCharactersInAString ex = new ExtraCharactersInAString();
        ex.minExtraChar("metzeaencgpgvsckjrqafkxgyzbe",new String[]{"zdzz","lgrhy","r","ohk","zkowk","g","zqpn","anoni","ka","qafkx","t","jr","xdye","mppc","bqqb","encgp","yf","vl","ctsxk","gn","cujh","ce","rwrpq","tze","zxhg","yzbe","c","o","hnk","gv","uzbc","xn","kk","ujjd","vv","mxhmv","ugn","at","kumr","ensv","x","uy","gb","ae","jljuo","xqkgj"});
    }

}
