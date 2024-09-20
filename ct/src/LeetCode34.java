public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1,end = -1;
        //non-desc 비내림차순 ==> 중복요소있을수있음
        // nums = [1,1,1,1,1] / target = 1  이라면?, nums = [0,0,1,1,1,1,1,1,1,1] / target = 1이라면?
        // 이진탐색으로 찾고 양쪽으로 뻗어나가기?
        while (left <= right) {
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                left = mid + 1; //오른쪽에도 있는지 확인
                end = mid;
            }else{
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

        }

        if(start == -1){// start 값이 -1이라면 해당하는 값이 없다는 뜻
            return new int[]{-1, -1};
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                right = mid - 1; //오른쪽에도 있는지 확인
                start = mid;
            }else{
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

        }
        

        return  new int[]{start,end};
    }
    


    public static void main(String[] args) {
        LeetCode34 leetcode = new LeetCode34();
        int[] ints = leetcode.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int i : ints){
            System.out.println("i = " + i);
        }
    }
}
