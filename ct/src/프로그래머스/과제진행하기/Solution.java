package 프로그래머스.과제진행하기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    class Plan{
        String name;
        int rem;
        public Plan(String name, int rem) {
            this.name = name;
            this.rem = rem;
        }
    }
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        Arrays.sort(plans,(a,b) -> a[1].compareTo(b[1]));
        Stack<Plan> stack = new Stack<Plan>();
        int ans = 0;
        for (int i = 0 ; i < n ;i++){
            int cur = timeTonInteger(plans[i][1].split(":")[0],plans[i][1].split(":")[1]);
            int next = Integer.MAX_VALUE;
            if(i < n-1) next = timeTonInteger(plans[i+1][1].split(":")[0],plans[i+1][1].split(":")[1]);

            int diff = next-cur;
            if(diff < Integer.parseInt(plans[i][2])){
                stack.push(new Plan(plans[i][0],Integer.parseInt(plans[i][2])-diff));
            }else{
                answer[ans++] = plans[i][0];
                diff -= Integer.parseInt(plans[i][2]);
                while(!stack.isEmpty() && diff > 0){
                    Plan pop = stack.pop();
                    if(pop.rem <= diff){
                        diff -= pop.rem;
                        answer[ans++] = pop.name;
                    }else{
                        pop.rem -= diff;
                        diff = 0;
                        stack.push(pop);
                    }
                }
            }
        }
        return answer;
    }
    public int timeTonInteger(String h,String m) {
        return Integer.parseInt(h)*60 + Integer.parseInt(m);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
    }
}
