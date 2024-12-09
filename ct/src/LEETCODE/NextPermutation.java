import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {


        int head = nums.length - 2;
        int tail = nums.length - 1;

        while (head >= 0) {

            if(nums[head] < nums[tail]) {
               tail = nums.length - 1;
               while (tail > head){
                   if(nums[tail] > nums[head]) {
                       break;
                   }
                   tail--;
               }

               swap(nums, head, tail);
               reverse(nums,head+1);

               return;
            }else{//head가 더 크다면 이전 자릿수에서 바꿔야함
                head--;
                tail--;
            }
        }
        reverse(nums,0);
    }
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] arr,int start){
        int end  = arr.length-1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
