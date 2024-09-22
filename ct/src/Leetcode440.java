import java.util.ArrayList;
import java.util.List;

public class Leetcode440 {
    public int findKthNumber(int n, int k) {
        int res = 0;
        List<Integer> list = new ArrayList<Integer>();
        p( list,1,n,k);
        System.out.println(list);
        return list.get(list.size()-1);
    }

    public void p( List<Integer> list,int i,int n,int k){
        if(i > n)
            return;
        if(list.size() == k){
            return;
        }
        list.add(i);
        p(list,i*10,n,k);
        if(i+1 <= n && i%10 != 9)
            p(list,i+1,n,k);
    }

    public static void main(String[] args) {
        Leetcode440 leetcode = new Leetcode440();
        System.out.println(leetcode.findKthNumber(100, 90));
    }
}
