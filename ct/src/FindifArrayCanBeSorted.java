public class FindifArrayCanBeSorted {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j+1]){
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindifArrayCanBeSorted f = new FindifArrayCanBeSorted();
        System.out.println(f.canSortArray(new int[]{1,2,3,4}));
    }
}
