import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        if(nums[0] < nums[nums.length - 1] && nums[nums.length - 1] < target)
            return -1;

        int res = 0;

        if(nums[0] > nums[nums.length - 1]){//rotate한 경우에는 탐색할 범위를 찾아야한다
            int s = 0;
            while(nums[s] < nums[s+1]){
                s++;
            }
            if(nums[0] <= target){
                return binarySearch(nums, target,0,s+1);
            }else{
                return binarySearch(nums, target,s+1,nums.length);
            }
        }else{
            return binarySearch(nums, target,0,nums.length);
        }
    }
    public int binarySearch(int[] nums, int target,int left,int right) {
        
        while(right>left){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] > target){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
