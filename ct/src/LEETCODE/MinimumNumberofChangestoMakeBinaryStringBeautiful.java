public class MinimumNumberofChangestoMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        char[] arr = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < arr.length; i+=2) {//연속한 두 문자가 서로다를때 1을 더해주면된다.
            if (arr[i] !=arr[i+1]) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MinimumNumberofChangestoMakeBinaryStringBeautiful m = new MinimumNumberofChangestoMakeBinaryStringBeautiful();
        m.minChanges("10");
    }
}
