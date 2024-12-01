package LEETCODE.CheckIfNandItsDoubleExist;

import java.util.*;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i*2) || (i % 2 ==0 && set.contains(i/2))){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkIfExist(new int[]{-10, 12, -20, -8, 15});
    }
}
