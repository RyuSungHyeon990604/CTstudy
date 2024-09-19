import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        if(nums[0] < nums[nums.length - 1] && nums[nums.length - 1] < target)
            return -1;

        int res = 0;

        if(nums[0] > nums[nums.length - 1]){//rotate한 경우에는 탐색할 범위를 찾아야한다

            //피벗또한 이진탐색으로 찾을 수 있다
            //mid값과 right를 비교하여 mid 값이 크다면 피벗은 오른쪽에
            //작다면 왼쪽에 피벗이 존재함
            int pivot = 0;
            int left = 0,right = nums.length - 1;
            while(left < right){
                int mid = (left + right) / 2;
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            pivot = right;
            if(nums[0] <= target){
                return binarySearch(nums, target,0,pivot-1);
            }else{
                return binarySearch(nums, target,pivot,nums.length-1);
            }
        }else{
            return binarySearch(nums, target,0,nums.length-1);
        }
    }
    public int binarySearch(int[] nums, int target,int left,int right) {
        
        while(right>=left){ // 이진 탐색에서는 left 값과 right값이 같을경우에 체크해야함 ==>  ex) 1 3 4  target 이 3일경우에
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int search1 = search.search(new int[]{1,3,4}, 3);
        System.out.println("search1 = " + search1);
    }
}
