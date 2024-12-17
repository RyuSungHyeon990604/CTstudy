package LEETCODE.ConstructStringWithRepeatLimit;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        // 문자 빈도 계산
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 25; i >= 0;) {
            if (freq[i] == 0) {
                i--;
                continue;
            }

            int use = Math.min(freq[i], repeatLimit); // 사용할 문자 개수
            appendChars(sb, i, use); // 반복 문자 추가
            freq[i] -= use;

            if (freq[i] > 0) { // 제한에 걸려 더 이상 추가할 수 없는 경우
                int next = findNext(freq, i - 1); // 다음 사용할 문자 찾기
                if (next == -1) break; // 더 이상 추가할 문자가 없으면 종료
                appendChars(sb, next, 1);
                freq[next]--;
            } else {
                i--;
            }
        }
        return sb.toString();
    }

    private void appendChars(StringBuilder sb, int index, int count) {
        for (int i = 0; i < count; i++) {
            sb.append((char)('a' + index));
        }
    }

    private int findNext(int[] freq, int start) {
        while (start >= 0 && freq[start] == 0) start--;
        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //String s1 = s.repeatLimitedString("aaaaabbbbb", 3);
        byte[] res;
        String a= "asd";
        res = a.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        System.out.println(new String(res));

    }
}
