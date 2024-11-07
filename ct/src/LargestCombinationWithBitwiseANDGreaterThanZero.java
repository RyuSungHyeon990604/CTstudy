public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {
        int answer = 0;
        //1 <= candidates[i] <= 10^7
        //16777216 / 10^7 보다 큰 지수 == 24
        int[] count = new int[24];

        //각 숫자를 이진수로 치환했을때의 1의 위치를 카운팅
        //count[i]의 값 ==> 이진수로 치환했을때 1이 i에 존재하는 숫자가 count[i]개 ==> 즉 모두 AND 연산했을때 적어도 1이상이 나오는 candidates 의 부분집합의 최대길이
        for(int i = 0; i < candidates.length; i++) {
           int n = candidates[i];
           int index = 0;
           while(n > 0){
               if((n & 1) == 1 )
                   count[index]++;
               n = n>>1;
               index++;
           }
        }
        for(int i = 0; i < 24; i++) {
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }


    public static void main(String[] args) {
        LargestCombinationWithBitwiseANDGreaterThanZero l = new LargestCombinationWithBitwiseANDGreaterThanZero();
        System.out.println(l.largestCombination(new int[]{16,17,71,62,12,24,14}));
    }

}
