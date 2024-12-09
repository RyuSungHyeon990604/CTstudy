public class TakeKofEachCharacterFromLeftandRight {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        int n = s.length();

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (count[i] < k) return -1;
        }

        char[] c=s.toCharArray();
        int[] mid = new int[3];
        int left = 0, max = 0;

        //슬라이딩 윈도우
        //right값까지 윈도우 크기를 늘리고
        //left값으로 줄여나간다.
        for (int right = 0; right < n; right++) {
            mid[c[right] - 'a']++;

            while (left <= right && (count[0] - mid[0] < k || count[1] - mid[1] < k || count[2] - mid[2] < k)) {
                mid[c[left] - 'a']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return n - max;
    }

    public static void main(String[] args) {
        TakeKofEachCharacterFromLeftandRight t = new TakeKofEachCharacterFromLeftandRight();
        int i = t.takeCharacters("aabbccca", 2);
        System.out.println("i = " + i);
    }
}
