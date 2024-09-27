import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(res, new ArrayList<>(), candidates,  target,0);

        return res;
    }

    public void combination(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int index) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] > target) {//target은 점점작아지다 0 또는 -1가 되는순간 재귀를 멈춘다
                break;
            }
            list.add(candidates[i]);
            combination(res, list, candidates,  target-candidates[i],i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum CombinationSum = new CombinationSum();
        List<List<Integer>> lists = CombinationSum.combinationSum(new int[]{2, 3, 6, 7,8}, 7);
        System.out.println(lists);
    }
}
