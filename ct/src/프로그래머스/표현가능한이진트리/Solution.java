package 프로그래머스.표현가능한이진트리;

public class Solution {
    int[] h = {1,2,3,4,5,6};
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            long cur = numbers[i];
            //numbers[i]를 나타낼수있는 포화이진 트리의 높이
            int curH = getH(cur);
            //포화이진 트리의 최상위 루트노드의 번호
            int center = (1<<(curH-1));
            //최상위 루트노드가 0이라면 조건을 만족할수없으므로 answer[i] = 0
            if( (cur&(1L << center-1)) == 0) {
                answer[i] = 0;
                continue;
            }
            int dfs = dfs(cur, center, curH);

            answer[i] = dfs == 2 ? 0 : 1;

        }
        return answer;
    }
    public int dfs(long number,int center,int h) {
        //리프노드라면 현재 위치의 비트값을 반환
        if(h == 1){
            return (number&(1L <<(center-1))) != 0 ? 1 : 0;
        }
        int cur = (number&(1L <<(center-1))) != 0 ? 1 : 0;
        //오른쪽 자식 노드
        int right = dfs(number,center + (1<<(h-2)),h-1);
        //왼쪽 자식 노드
        int left = dfs(number,center - (1<<(h-2)),h-1);


        if(right == 2 || left == 2)
            return 2;

        if(cur == 1){
            return 1;
        }else{
            if(right == 0 && left == 0){
                return 0;
            }else{
                //현재 위치의 비트값이 0인데 자식 노드의 비트값이 모두 0이 아니라면 조건을 만조할수없음
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
