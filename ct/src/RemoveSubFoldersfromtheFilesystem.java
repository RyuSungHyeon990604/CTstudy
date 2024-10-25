import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Trie{
    Trie[] child = new Trie[27];
    boolean isLast = false;
}

class Root{
    Trie root = new Trie();
    public void insert(String path){
        Trie current = root;
        for(char c : path.toCharArray()){
            int i = c - 'a';
            if(c == '/'){
                i = 26;
            }
            if(current.child[i] == null){
                current.child[i] = new Trie();
            }
            current = current.child[i];
        }
        //  /a/b/c  /a/b/ca 같은 경우를 대비해서
        //마지막에 문자 '/'를 하나 추가해준다
        current.child[26] = new Trie();
        current.child[26].isLast = true;
    }
    public boolean isSubfolder(String path){
        Trie current = root;
        for(char c : path.toCharArray()){
            int i = c - 'a';
            if(c == '/'){
                i = 26;
            }
            if(current.child[i] == null) return false; // 다음 루트가 없다면 서브폴더가 아니다
            current = current.child[i];
            if(current.isLast){//완성된 경로가있다면 서브폴더이다
                return true;
            }

        }
        return false;
    }
}
public class RemoveSubFoldersfromtheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(s1,s2) -> s1.length() - s2.length());
        List<String> res= new ArrayList<String>();
        Root root = new Root();
        for(String s : folder){
            if(root.isSubfolder(s)){
                continue;
            }
            root.insert(s);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveSubFoldersfromtheFilesystem f = new RemoveSubFoldersfromtheFilesystem();
        f.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
    }
}
