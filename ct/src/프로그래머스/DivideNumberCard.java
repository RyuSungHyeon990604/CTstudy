import com.sun.security.jgss.GSSUtil;

public class DivideNumberCard {
    //[10, 17]	[5, 20]
    public int solution(int[] arrayA, int[] arrayB) {
        int A = r(arrayA);
        int B = r(arrayB);
        //A에서 나누어지지만 B에선 나누어지는가 확인
        int chkA = chk(arrayB, A);
        int chkB = chk(arrayA, B);
        System.out.println(A);
        System.out.println(B);


        return chkA > chkB ? chkA : chkB;
    }


    //유클리드호제법
    public int n(int a,int b){
        int r = b;
        while(a%b!=0){
           r = a%b;
           a = b;
           b = r;
        }
        return r;
    }
    //배열안의 값들의 최대공약수를 구한다
    // 14 30 102
    public int r(int[] arr){
        int res = arr[0];
        if(arr.length == 1) {
            return res;
        }
        for(int i = 0; i < arr.length-1; i++){
            res = n(res,arr[i+1]);

        }
        return res;
    }

    public int chk(int[] arr,int n){
        int res = n;
        for (int a : arr){
            if(a%n == 0){
                res = 0;
                break;
            }
        }
        return res;
    }
}
