import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadUser {
    Set<Set<String>> answer = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            List<String> matchedID = new ArrayList<String>();
            for (int j = 0; j < user_id.length; j++) {
                if(isMatched(user_id[j].toCharArray(),banned_id[i].toCharArray())){
                    matchedID.add(user_id[j]);
                }
            }
            list.add(matchedID);
        }
        comb(list,new HashSet<>(),0);
        return answer.size();
    }

    public boolean isMatched(char[] user_id, char[] banned_id) {
       if(user_id.length != banned_id.length){
           return false;
       }
       for (int i = 0; i < user_id.length; i++) {
           if(user_id[i] != banned_id[i]){
               if(banned_id[i] != '*'){
                   return false;
               }
           }
       }
       return true;
    }

    public void comb(List<List<String>> list,Set<String> result,int index){
        if(result.size() == list.size()){
            answer.add(new HashSet<>(result));
            return;
        }
        for (int i = 0 ; i < list.get(index).size() ; i++){
            if(result.add(list.get(index).get(i))){
                comb(list,result,index+1);
                result.remove(list.get(index).get(i));
            }
        }
    }

    public static void main(String[] args) {
        BadUser badUser = new BadUser();
        badUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"fr*d*", "*rodo", "******", "******"});
    }
}
