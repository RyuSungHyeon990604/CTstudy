package LEETCODE.CheckIfNandItsDoubleExist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length ; i++) {
            int target = arr[i]*2;
            if(target > arr[arr.length-1]){
                return false;
            }
            int left = i, right = arr.length - 1;
            if(target < 0){
                left = 0;
                right = i;

            }
            while(left <= right){
                int mid = (left + right)/2;
                if(arr[mid] == target && mid != i){
                    return true;
                }else{
                    if(arr[mid] > target){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkIfExist(new int[]{-766,259,203,601,896,-226,-844,168,126,-542,159,-833,950,-454,-253,824,-395,155,94,894,-766,-63,836,-433,-780,611,-907,695,-395,-975,256,373,-971,-813,-154,-765,691,812,617,-919,-616,-510,608,201,-138,-669,-764,-77,-658,394,-506,-675,523});
    }
}
