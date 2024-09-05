public class ZigzagConversion {
    //s = "PAYPALISHIRING", numRows = 4
    //Output: "PINALSIGYAHRPI"
    //Explanation:
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I
    public String convert(String s, int numRows) {
        char[] ans = new char[s.length()];
        char[] charArray = s.toCharArray();
        String answer= "";
        int a = numRows-2 + numRows;
        if(a == 0){
            return s;
        }
        int index = 0;
        for (int i = 0 ; i< numRows ; i++) {
            int n = i;
            while (n < s.length()) {
                ans[index] = charArray[n];
                index++;
                // (numRows - i) * 2
                // numRows == 3
                if(i > 0 &&  i < numRows-1)
                    if (n+(numRows-1 - i)*2 < s.length()) {
                        ans[index] = charArray[n+(numRows-1 - i)*2];
                        index++;
                    }
                n += a;
            }
        }
        answer = new String(ans);
        return answer;
    }
}
