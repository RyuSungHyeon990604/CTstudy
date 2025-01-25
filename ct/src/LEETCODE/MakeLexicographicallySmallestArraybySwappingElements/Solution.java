package LEETCODE.MakeLexicographicallySmallestArraybySwappingElements;

import java.util.*;

public class Solution {
    class Group{
        int top = 0;
        List<Integer> list = new ArrayList<>();
        public Group(){}
        public Group(int n){
            add(n);
        }
        public void add(int v){
            list.add(v);
        }
        public int get(){
            return list.get(top++);
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        Map<Integer,Integer> group = new HashMap<>();
        int g = 0;
        group.put(arr[0],g);
        Map<Integer, Group> group2 = new HashMap<>();
        group2.put(g,new Group(arr[0]));
        for(int i = 1; i< nums.length ;i++){
            if(arr[i] - arr[i-1] > limit){
                g++;
                group2.put(g, new Group());
            }
            group.put(arr[i],g);
            group2.get(g).add(arr[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int numGroup = group.get(num);
            nums[i] = group2.get(numGroup).get();
        }
        return nums;
    }
}
