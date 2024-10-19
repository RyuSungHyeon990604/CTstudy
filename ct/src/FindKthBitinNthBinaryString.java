public class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        if(k == 0)
            return '0';
        return findKth(n, k);
    }

    public char findKth(int n, int k) {
        if (n == 1) {//첫번째 문자는 항상 0
            return '0';
        }
        int length = (1 << n) - 1; //2^n-1
        int mid = length / 2 + 1;


        //S1 = "0"
        //Si = S(i - 1) + "1" + reverse(invert(S(i - 1)))

        //Si의 길이는 2^n-1
        //중앙의 문자는 항상 "1"
        //mid값을 기준으로  S(i - 1)와 reverse(invert(S(i - 1)))을 나눈다
        //S1 = "0"
        //S2 = "0 1 1"
        //S3 = "011 1 001"
        //S4 = "0111001 1 0110001"
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKth(n - 1, k);
        } else {
            return invert(findKth(n - 1, length - k + 1));//중앙 1을 기준으로 대칭이므로 k,length - k + 1 위치의 문자가 대칭을 이룬다
        }
    }
    public char invert(char c) {
        return c == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        FindKthBitinNthBinaryString obj = new FindKthBitinNthBinaryString();
        System.out.println(obj.findKthBit(3, 3));
    }
}
