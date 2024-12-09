import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // {1,1,3} 3개의 숫자에서 {1,3} 2개의 숫자로 생각해야한다
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        permutations(nums,res,new ArrayList<>(),map);
        return res;
    }

    public void permutations(int[] nums,List<List<Integer>> res,List<Integer> list, Map<Integer, Integer> map){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        map.forEach((k,v)->{
            if(v > 0){
                list.add(k);
                map.put(k,v-1);
                permutations(nums,res,list,map);
                list.remove(list.size()-1);
                map.put(k,v);
            }
        });
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(new int[]{1,1,3}));
    }
}
