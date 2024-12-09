public class LongestPalindromeStr {
    public int solution(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        char[] c = s.toCharArray();
        int len = 1;
        for (int i = 0; i < c.length; i++) {
            //펠린드롬 문자의 길이가 짝수일때
            int leftEven = i;
            int rightEven = i + 1;
            while (leftEven < rightEven && leftEven >= 0  && rightEven < c.length && c[leftEven] == c[rightEven]) {
                len = Math.max(len, rightEven - leftEven + 1);
                leftEven--;
                rightEven++;
            }

            //펠린드롬 문자의 길이가 홀수일때
            int leftOdd = i;
            int rightOdd = i + 2;
            while (leftOdd < rightOdd && leftOdd >= 0  && rightOdd < c.length && c[leftOdd] == c[rightOdd]) {
                len = Math.max(len, rightOdd - leftOdd + 1);
                leftOdd--;
                rightOdd++;
            }

        }

        return len;
    }

    public static void main(String[] args) {
        LongestPalindromeStr str = new LongestPalindromeStr();
        int solution = str.solution("aac");
        System.out.println("solution = " + solution);
    }
}
