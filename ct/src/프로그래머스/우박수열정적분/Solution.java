package 프로그래머스.우박수열정적분;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        list.add(k);
        int n=0;
        while(k!=1){
            if((k&1)==1){
                k = k*3 + 1;
            }else{
                k/=2;
            }
            n++;
            list.add(k);
        }
        double[] prefix = new double[n+1];
        prefix[0] = 0;
        for(int i=1;i<n+1;i++){
            prefix[i] = prefix[i-1]+(list.get(i-1)+list.get(i))/2.0;
        }

        for(int i=0;i<ranges.length;i++){
            int start  = ranges[i][0];
            int end = n+ranges[i][1];
            if(start > end){
                answer[i] = -1.0;
            }else{
                answer[i] = prefix[end]-prefix[start];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        s.solution(5,new int[][]{{0,0},{0,-1},{2,-3},{3,-3}});
    }
}
