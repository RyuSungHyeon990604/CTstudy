public class StringToInteger {
    public int myAtoi(String s) {
        long ans = 0;
        boolean neg = false;
        int start = 0;
        char[] charArray = s.trim().toCharArray();
        if(s.trim().equals("")) return 0;
        if(charArray[0] == '-' || charArray[0] == '+') {
            neg = charArray[0] == '-';
            start = 1;
        }else if(charArray[0] > 57 || charArray[0] < 48 ) return 0;


        for (; start < charArray.length; start++) {
            if(charArray[start] > 57 || charArray[start] < 48 ){
                break;
            }
            ans = ans * 10 + charArray[start] - 48;
            if(ans > Integer.MAX_VALUE) {
                ans = neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                break;
            }
        }
        if(neg) {
           ans = ans * -1;
        }
        return (int) ans;
    }
}
