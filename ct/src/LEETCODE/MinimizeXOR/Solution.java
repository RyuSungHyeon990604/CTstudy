package LEETCODE.MinimizeXOR;

public class Solution {
    public int minimizeXor(int num1, int num2) {
        int bit = Integer.bitCount(num1);
        int target = Integer.bitCount(num2);
        int answer = num1;
        int diff = Math.abs(target - bit);
        int cur = 0;
        if(bit > target){//비트를 제거해야함
            while(diff > 0){
                if((answer & (1<<cur)) > 0){
                    answer = answer ^ (1<<cur);
                    diff--;
                }
                cur++;
            }
        }else if(bit < target){//비트를 추가해야함
            while(diff > 0){
                if((answer & (1<<cur)) == 0){
                    answer = answer | (1<<cur);
                    diff--;
                }
                cur++;
            }
        }else return answer;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimizeXor(1,12);
    }
}
