public class CountNumberofMaximumBitwiseORSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int max = calc(nums);
        int[] ans = new int[]{0,0,max};
        sub(nums,0,ans);
        return ans[0];
    }
    public void sub(int[] nums , int start, int[] ans){
        if(ans[1] == ans[2]){
            ans[0]++;
        }
        for(int i = start ; i < nums.length ; i++){
            int t = ans[1];
            ans[1] = t | nums[i];
            sub(nums, i+1, ans);
            ans[1] = t;
        }
    }
    public int calc(int[] nums){
        int t=0;
        for(int i=0; i<nums.length; i++){
            t = t | nums[i];
        }
        return t;
    }

    public static void main(String[] args) {
        CountNumberofMaximumBitwiseORSubsets c = new CountNumberofMaximumBitwiseORSubsets();
        c.countMaxOrSubsets(new int[]{2,2,2});
    }
}
