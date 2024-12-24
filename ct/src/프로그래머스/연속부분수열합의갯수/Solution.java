package 프로그래머스.연속부분수열합의갯수;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //펜윅트리 써보기
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[2*n+1];
        int[] BIT = new int[2*n+1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 2*n+1; i++) {
            arr[i] = elements[(i-1)%n];
        }
        for (int i = 1; i < 2*n+1; i++) {
            add(BIT,arr[i],i);
        }
        for (int len = 1; len < n; len++) {
            for (int start = 0; start < n; start++) {
                int sum1 = getSum(BIT,start);
                int sum2 = getSum(BIT,start+len);
                set.add(sum2-sum1);
            }
        }
        
        //길이가 n인 경우 +1
        return set.size()+1;
    }
    public void add(int[] BIT, int v,int cur) {
        while ( cur < BIT.length) {
            BIT[cur]+=v;
            cur += (cur&-cur);
        }
    }
    public int getSum(int[] BIT,int cur) {
        int sum = 0;
        while(cur > 0){
            sum += BIT[cur];
            cur -= (cur&-cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{7,9,1,1,4});
    }
}
