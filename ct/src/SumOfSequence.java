public class SumOfSequence {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        int start = 0, end = 0;
        int sum = 0;
        int min =1000001;
        while (end < sequence.length) {
            sum += sequence[end];
            while(sum > k){
                sum -= sequence[start];
                start++;
            }
            if (sum == k) {
                if(min == end - start){
                }
                else if(min > end - start){
                    answer = new int[]{start,end};
                    min = end - start;
                }
            }
            end++;
        }
        return answer;
    }
}
