public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        StringBuilder ans = new StringBuilder();
        boolean negative = true;
        //dividend == -2147483648 일때 long 으로 캐스팅을 안해주니 Math.abs() 를 해줌에도 절댓값이 아닌 -부호가 나옴.
        // Integer.MAX_VALUE == 2147483647
        // Integer.MIN_VALUE == -2147483648
        // 즉 -2147483648 * -1 = 2147483648 은 INT 자료형의 범위를 벗어나기 때문에 -가 나옴
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        if(a == 0 || a < b){
            return 0;
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            negative = false;
        }
        if(divisor == 0)
            throw new ArithmeticException("Divide by zero");

        int bitSize = 0;// 이진수의 자릿수
        long dummy = b; // 원래의 divisor값은 유지해야한다, 시프트연산을 하면서 소실되는 값이 생길수있음
        while(dummy <= a){
            dummy = dummy << 1;
            bitSize++;
        }
        for (int i = bitSize - 1 ; i >= 0 ; i--){
            b = b << i;
            if(a >= b){
                ans.append('1');
                a = a - b;
                b = b >> i;
            }else{
                ans.append('0');
            }
        }


        long res = Long.parseLong(ans.toString(),2);
        res = negative ?  -res :  res;
        if(res >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(res <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) res;
    }
}
