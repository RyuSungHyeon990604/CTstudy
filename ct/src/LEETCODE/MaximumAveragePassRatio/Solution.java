package LEETCODE.MaximumAveragePassRatio;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());
        for(int[] cl : classes){
            pq.add(new ClassRecord(cl));
        }
        ClassRecord cl;
        while(extraStudents-- > 0){
            pq.add(pq.remove().addOneStudent());
        }
        double sum = 0;
        while(!pq.isEmpty()){
            cl = pq.remove();
            sum += (double)cl.pass / cl.total;
        }
        return sum / classes.length;
    }
    class ClassRecord{
        int pass;
        int total;
        double inc;
        public ClassRecord(int[] array){
            pass = array[0];
            total = array[1];
            inc = getIncrement();
        }
        public ClassRecord addOneStudent(){
            pass++;
            total++;
            inc = getIncrement();
            return this;
        }
        private double getIncrement(){
            return (pass + 1.0) / (total + 1) - (double)pass / total;
        }
    }
    class Compare implements Comparator<ClassRecord> {
        public int compare(ClassRecord a, ClassRecord b) {
            if (a.inc < b.inc) {//b가 더 크다면
                return 1;//양수이므로 b 우선
            } else if (a.inc > b.inc) {//a가 더 크다면
                return -1;//음수이므로 a 우선
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxAverageRatio(new int[][]{{2,4}},4);
    }
}
