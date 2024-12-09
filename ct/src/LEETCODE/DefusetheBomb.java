public class DefusetheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        if( k == 0) return answer;
        int start = 1;
        int end = k;
        if( k < 0){
            start = code.length + k;
            end = code.length - 1;
        }
        int sum = 0;
        //일일히 sum을 초기화하고 값을 더할필요가없음
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }
        //어짜피 이동은 한칸씩 고정
        //즉, sum 에서 code[start] 를 빼고 code[end+1]을 더해주면  answer[i+1] 의 값이 나온다
        for (int i = 0; i <= end; i++) {
            answer[i] = sum;
            sum -= code[start%code.length];
            sum += code[(end+1)%code.length];
            start++;
            end++;
        }
        return answer;
    }

    public static void main(String[] args) {
        DefusetheBomb d = new DefusetheBomb();
        d.decrypt(new int[]{2,4,9,3}, -2);
    }
}
