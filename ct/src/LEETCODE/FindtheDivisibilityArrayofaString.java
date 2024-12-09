public class FindtheDivisibilityArrayofaString {
    public int[] divisibilityArray(String word, int m) {
        int[] res =  new int[word.length()];
        long mod =0L;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            mod = ((mod*10) + (ch-'0'))%m;
            if(mod == 0)
                res[i] = 1;
        }

        return res;
    }

    public static void main(String[] args) {
        FindtheDivisibilityArrayofaString obj = new FindtheDivisibilityArrayofaString();
        int[] res = obj.divisibilityArray("86217457695827338571", 8);
    }
}
