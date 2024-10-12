import java.util.*;

public class CandidateKey {
    int answer = 0;
    Set<Set<Integer>> keySet =new HashSet<>();
    public int solution(String[][] relation) {
        List<Set<Integer>> keys = new ArrayList<>();
        key(relation,new HashSet<>(),0,0,keys);
        Collections.sort(keys,Comparator.comparingInt(Set::size));
        keys.remove(0);
        for (Set<Integer> key : keys) {
            boolean isKey = true;
            Set<String> db =new HashSet<>();
            for(int j=0;j<relation.length;j++) {
                StringBuilder sb = new StringBuilder();
                for (int i : key) {
                    sb.append(relation[j][i]).append(',');
                }
                if(!db.add(sb.toString())){
                    isKey = false;
                    break;
                }
            }
            if(isKey){
                if(chk(key)){
                    answer++;
                    keySet.add(key);
                }
            }
        }

        return answer;
    }

    public void key(String[][] relation, Set<Integer> key,int depth,int start,List<Set<Integer>> list){

        list.add(new HashSet<>(key));
        for(int i=start;i<relation[0].length;i++){
            key.add(i);
            key(relation, key, depth + 1, i + 1,list);  // i+1을 통해 중복된 인덱스를 피함
            key.remove(i);
        }
    }
    public boolean chk(Set<Integer> key){
        for (Set<Integer> set : keySet) {
            if(key.containsAll(set)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        candidateKey.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
    }

}
