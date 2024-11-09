public class MinimumArrayEnd {
    public long minEnd(int n, int x) {
        //x가 만약 110110101 이라면
        //비트가 0인 위치에 0 ~ n-1 까지숫자를 이진수로 변환했을때의 각각의 비트를 넣어주면된다
        //ex
        //0 삽입            11011  0  1 '0' 1
        //1 삽입            11011  0  1 '1' 1
        //2('10')삽입       11011 '1' 1 '0' 1
        //3('11')삽입       11011 '1' 1 '1' 1
        if (n == 1)
            return x;
        long answer = 0;
        n = n - 1;
        int idx = 0;
        while(true){
            if((x&1) ==1){
                answer = answer + (1L <<idx);
            }else{//비트가 0인자리에는 n-1 의 비트를 넣어준다
                if(n != 0){
                    if((n&1) == 1)
                        answer = answer + (1L<<idx);
                    n = (n>>1);
                }
            }
            if(n == 0 && x == 0)
                break;
            idx++;
            x = (x>>1);
        }

        return answer;
    }

    public static void main(String[] args) {
        MinimumArrayEnd m = new MinimumArrayEnd();
        System.out.println(m.minEnd(3, 4));
    }
}
