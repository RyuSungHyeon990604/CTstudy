public class NumberBlock {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        int index = 0;
        for (long i = begin; i <= end; i++) {
            answer[index++] = (int) p(i);
        }


        return answer;
    }

    public int p(long n) {// n보다 작은 가장 큰 약수를 반환한다. 소수라면 1을 반환, 짝수라면 n.2의 값을 반환 할것임
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 1;
        int num = 1;// i로 나눴지만 전부 1천만이 넘을경우 가장 마지막 i가 1천만보다 작은 약수중에 가장 큰 약수다
        for(int i = 2; i <= Math.sqrt(n); i+=1) {
            if(n % i == 0) {
                num = i;
                if ((int) n / i > 10000000)
                    continue;
                return (int) n / i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        NumberBlock block = new NumberBlock();
        int[] solution = block.solution(477559014L, 477559014L);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
}
