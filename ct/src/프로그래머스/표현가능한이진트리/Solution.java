package 프로그래머스.표현가능한이진트리;

public class Solution {
    int[] h = {1,2,3,4,5,6};
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            long cur = numbers[i];
            int curH = getH(cur);
            long center = (1<<(curH-1));
            if( (cur&(1L <<(((1 << curH) - 1) - center))) == 0) {
                answer[i] = 0;
                continue;
            }
            int dfs = dfs(cur, center, curH, (1 << curH) - 1);

            answer[i] = dfs == 2 ? 0 : 1;

        }
        return answer;
    }
    public int dfs(long number,long center,int h,int cnt) {
        if(h == 1){
            return (number&(1L <<(cnt - center))) != 0 ? 1 : 0;
        }
        int cur = (number&(1L <<(cnt - center))) != 0 ? 1 : 0;
        int right = dfs(number,center + (1<<(h-2)),h-1, cnt);
        int left = dfs(number,center - (1<<(h-2)),h-1, cnt);

        if(right == 2 || left == 2)
            return 2;

        if(cur == 1){
            return 1;
        }else{
            if(right == 0 && left == 0){
                return 0;
            }else{
                //완전 불가능
                return 2;
            }
        }
    }
    public int getH(long number) {
        int bitC = 0;
        while (number != 0) {
            number = number >> 1;
            bitC++;
        }
        for (int i = 0; i < h.length; i++) {
            if(bitC <= (1<<h[i])-1){
                return h[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       solution.solution(new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555L});
    }
}
