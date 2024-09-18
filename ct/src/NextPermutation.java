import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int[] clone = nums.clone();
        Arrays.sort(clone);

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

               int temp = nums[head];
               nums[head] = nums[tail];
               nums[tail] = temp;
               head++;
               tail = nums.length - 1;
               while(head < tail){
                   int tmp = nums[head];
                   nums[head] = nums[tail];
                   nums[tail] = tmp;
                   head++;
                   tail--;
               }

               break;
            }else{//head가 더 크다면 이전 자릿수에서 바꿔야함
                head--;
                tail--;
            }

            if(head == -1){
                head = 0 ;
                tail = nums.length - 1;
                while(head < tail){
                    int tmp = nums[head];
                    nums[head] = nums[tail];
                    nums[tail] = tmp;
                    head++;
                    tail--;
                }
                break;
            }
        }
    }
}
