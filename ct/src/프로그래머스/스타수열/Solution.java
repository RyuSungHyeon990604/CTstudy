package 프로그래머스.스타수열;

public class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[a[i]]++;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > 0 && answer < freq[i]*2) {
                int len = 0;
                for (int j = 0; j < n-1; j++) {
                    if((a[j] != a[j+1]) && (a[j] == i || a[j+1] == i)){
                        len+=2;
                        freq[j]--;
                        j++;
                    }
                }
                answer = Math.max(answer, len);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{5, 2, 3, 3, 5, 3});
    }
}
