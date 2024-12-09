package 프로그래머스.SpecialArrayII;

public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int group = 1;
        boolean[] answer= new boolean[queries.length];
        int[] newNums = new int[nums.length];
        newNums[0] = group;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int cur = nums[i];
            if((cur&1) == (prev&1)){
                group++;
            }
            newNums[i] = group;

        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(newNums[start] == newNums[end]){
                answer[i] = true;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isArraySpecial(new int[]{4,3,1,6},new int[][]{{0,2},{2,3}});
    }
}
