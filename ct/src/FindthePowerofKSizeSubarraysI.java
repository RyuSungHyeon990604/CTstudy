public class  FindthePowerofKSizeSubarraysI {
    public int[] resultsArray(int[] nums, int k) {
        if( k == 1)
            return nums;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0 ;i <= nums.length - k;i++) {
            for (int j = i+1; j < i+k ; j++) {
                if (j > i) {
                    if(nums[j] != nums[j -1] + 1) {
                        res[i] = -1;
                        break;
                    }else{
                        res[i] = nums[j];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindthePowerofKSizeSubarraysI obj = new FindthePowerofKSizeSubarraysI();
        obj.resultsArray(new int[]{1,2,3,2},3);
    }

}
