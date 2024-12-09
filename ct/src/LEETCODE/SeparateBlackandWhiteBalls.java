public class SeparateBlackandWhiteBalls {
    public long minimumSteps(String s) {
        long ans = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
            if (c == '0') {
                ans += count;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SeparateBlackandWhiteBalls s = new SeparateBlackandWhiteBalls();
        long l = s.minimumSteps("100");
        System.out.println("l = " + l);
    }
}
