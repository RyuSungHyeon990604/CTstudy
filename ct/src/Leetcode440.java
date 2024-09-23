import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode440 {
    class Root{
        Trie nodes;
        int size=0;
        Root(){
            this.nodes = new Trie();
        }
        public void create(int i,int n,int k){
            this.nodes.insert(i,n,k);
        }

    }
    class Trie{
        Root root;
        Map<Character, Trie> child = new HashMap<>();
        public Trie(){}
        public  Trie(Root root){
            this.root = root;
        }

        public void insert(int i, int n,int k){
          if(i > n)
              return;
          //insert 1 10 100 11 12 13 2
            String s = String.valueOf(i);
            Map<Character, Trie> t = this.child;
            for(char c : s.toCharArray()){
                if(t.containsKey(c)){
                    t = t.get(c).child;
                }else{
                    t.put(c, new Trie());
                }
            }
            insert(i*10,n,k);
          if(i+1 <= n && i%10 !=9)
              insert(i+1,n,k);
        }
    }
    public int findKthNumber(int n, int k) {
        Root root = new Root();
        root.nodes = new Trie(root);
        root.create(1,n,k);
        Map<Character, Trie> child = root.nodes.child;


        return 0;
    }

    public void p( List<Integer> list,int i,int n,int k){
        if(i > n)
            return;
        if(list.size() == k){
            return;
        }
        list.add(i);
        p(list,i*10,n,k);
        if(i+1 <= n && i%10 != 9)
            p(list,i+1,n,k);
    }

    public static void main(String[] args) {
        Leetcode440 leetcode = new Leetcode440();
        System.out.println(leetcode.findKthNumber(681692778, 351251360));
    }
}
