import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int[] arr = new int[candidates[candidates.length-1]+1];
        for(int i = 0; i < candidates.length; i++) {
            arr[candidates[i]]++;
        }
        sum(arr,res,new ArrayList<>(),0,target);
        return res;
    }

    public void sum(int[] candidates,List<List<Integer>> res,List<Integer> list,int start,int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i  = start; i < candidates.length; i++) {
            if(target< 0) return;
            if(candidates[i] > 0){
                list.add(i);
                candidates[i]--;
                int s = candidates[i] > 0 ? i : i+1;
                sum(candidates,res,list,s,target-i);
                list.remove(list.size()-1);
                candidates[i]++;
            }

        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> lists = combinationSumII.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println("lists = " + lists);
    }
}
