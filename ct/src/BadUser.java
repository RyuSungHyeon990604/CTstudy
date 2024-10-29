import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadUser {

    public int solution(String[] user_id, String[] banned_id) {
        Set<Integer> answer = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            List<Integer> matchedID = new ArrayList<Integer>();
            for (int j = 0; j < user_id.length; j++) {
                if(isMatched(user_id[j].toCharArray(),banned_id[i].toCharArray())){
                    //j = 1 ==> 10 == 2 넣는다
                    matchedID.add(1<<j);
                }
            }
            list.add(matchedID);
        }
        comb(list,answer,0,0);
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

    public void comb(List<List<Integer>> list,Set<Integer> answer,int index,int n){
        if(index == list.size()){
            answer.add(n);
            return;
        }
        for (int i = 0 ; i < list.get(index).size() ; i++){
            if((n & list.get(index).get(i)) == 0)// n = 010 이고 list.get(index).get(i) = 101 이면 0 나온다.
                comb(list,answer,index+1,n  | list.get(index).get(i) );
        }
    }

    public static void main(String[] args) {
        BadUser badUser = new BadUser();
        badUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"fr*d*", "*rodo", "******", "******"});
    }
}
