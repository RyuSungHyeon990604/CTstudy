import java.util.*;

public class Leetcode440 {


    public int findKthNumber(int n, int k) {
        int count = k;
        int i =1;
        while(count > 0){
            long c = getCount(i,n);
            if(c < count){
                count-=c;
                i +=1;
            }else{
                count-=1;
                if(count == 0)
                    break;
                i*=10;
            }
        }
        return i;
    }

    public long getCount(int headNum ,int n){
        //1 10 100
        long count = 0;
        long start = headNum;
        long end = start+1;

        while(start <= n){
            //1 - 2  10 -20  100- 200  1000 -2000  n =18
            if(end <= n) // =를 제거하면 headNum == 1, n == 2일때 문제가생김
                count += end - start;
            else
                count += n - start + 1;
            start*=10;
            end*=10;
        }

        return count;
    }

    public static void main(String[] args) {
        Leetcode440 leetcode = new Leetcode440();
        System.out.println(leetcode.getCount(1,1));
//        System.out.println(leetcode.findKthNumber(2, 2));
    }
}
