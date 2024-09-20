public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //non-desc 비내림차순 ==> 중복요소있을수있음
        // nums = [1,1,1,1,1] / target = 1  이라면?, nums = [0,0,1,1,1,1,1,1,1,1] / target = 1이라면?
        // 이진탐색으로 찾고 양쪽으로 뻗어나가기?
        while (left <= right) {

//            if(left == right){ // 어짜피 최종 return 에 작성해놔서 필요없는부분
//                if(nums[left]!= target)
//                    return new int[]{-1,-1};
//            }

            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return new int[]{expandLeft(nums,target,mid),expandRight(nums,target,mid)};
            }else{
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

        }
        

        return  new int[]{-1,-1};
    }
    
    public int expandLeft(int[] nums, int target,int index) {
        int preIndex = index;
        if(index == 0 )
            return index;
        
        while(index >= 0){
            if(nums[index] != target){
                break;
            }
            preIndex = index;
            index--;
        }
        
        return preIndex;
    }

    public int expandRight(int[] nums, int target,int index) {
        int preIndex = index;
        if(index == nums.length - 1 )
            return index;

        while(index <= nums.length-1){
            if(nums[index] != target)
                break;
            preIndex = index;
            index++;
        }

        return preIndex;
    }

    public static void main(String[] args) {
        LeetCode34 leetcode = new LeetCode34();
        int[] ints = leetcode.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int i : ints){
            System.out.println("i = " + i);
        }
    }
}
