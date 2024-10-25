import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersfromtheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res= new ArrayList<String>();
        for (String s : folder) {
            if(res.isEmpty()){
                res.add(s);
            }else{
                if(s.startsWith(res.get(res.size()-1)+"/"))
                    continue;
                res.add(s);
            }

        }
        return res;
    }
}
