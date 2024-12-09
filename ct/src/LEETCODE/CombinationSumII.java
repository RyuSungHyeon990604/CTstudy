import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates,res,new ArrayList<>(),0,target);
        return res;
    }

    public void sum(int[] candidates,List<List<Integer>> res,List<Integer> list,int start,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i  = start; i < candidates.length; i++) {
            if(i> start && candidates[i] == candidates[i-1]) continue;
            if(target < candidates[i]) break;
            list.add(candidates[i]);
            sum(candidates,res,list,i+1,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> lists = combinationSumII.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println("lists = " + lists);
    }
}
