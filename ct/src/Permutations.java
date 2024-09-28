import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(res,new ArrayList<>(),nums,new int[nums.length]);
        return res;
    }

    public void permutations(List<List<Integer>> res,List<Integer> list,int[] nums,int[] vis){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0 ; i< nums.length ; i++){
            if(vis[i] == 0){
                vis[i] = 1;
                list.add(nums[i]);
                permutations(res,list,nums,vis);
                list.remove(list.size()-1);
                vis[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);
    }
}
